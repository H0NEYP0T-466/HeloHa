package com.example.heloha.screens
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.heloha.screens.Message
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var messageText by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<Message>() }
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val auth = FirebaseAuth.getInstance()
    val database = FirebaseDatabase.getInstance().getReference("group_chat")
    val currentUser = auth.currentUser
    var currentUserName by remember { mutableStateOf("...") }
    LaunchedEffect(currentUser) {
        currentUser?.uid?.let { uid ->
            FirebaseDatabase.getInstance().getReference("users").child(uid).child("name")
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        currentUserName = snapshot.getValue(String::class.java) ?: "Anonymous"
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle error
                    }
                })
        }
    }

    // Listen for new messages
    DisposableEffect(Unit) {
        val messageListener = object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val message = snapshot.getValue(Message::class.java)
                message?.let {
                    messages.add(it)
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(messages.size - 1)
                    }
                }
            }
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        }
        database.addChildEventListener(messageListener)

        onDispose {
            database.removeEventListener(messageListener)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pookies") },
                actions = {
                    TextButton(onClick = {
                        auth.signOut()
                        navController.navigate("login") {
                            popUpTo("home") { inclusive = true }
                        }
                    }) {
                        Text("Logout", color = MaterialTheme.colorScheme.primary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFADD8E6)
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = messageText,
                    onValueChange = { messageText = it },
                    placeholder = { Text("Type a message...") },
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {
                    if (messageText.isNotBlank()) {
                        val messageId = database.push().key ?: ""
                        val message = Message(
                            id = messageId,
                            text = messageText,
                            senderName = currentUserName,
                            senderId = currentUser?.uid ?: "",
                            timestamp = System.currentTimeMillis()
                        )
                        database.child(messageId).setValue(message)
                        messageText = ""
                    }
                }) {
                    Icon(Icons.Default.Send, contentDescription = "Send Message")
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 8.dp)
        ) {
            items(messages) { message ->
                MessageBubble(message = message, isCurrentUser = message.senderId == currentUser?.uid)
            }
        }
    }
}

@Composable
fun MessageBubble(message: Message, isCurrentUser: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalAlignment = if (isCurrentUser) Alignment.End else Alignment.Start
    ) {
        Text(
            text = if (isCurrentUser) "You" else message.senderName,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Box(
            modifier = Modifier
                .background(
                    if (isCurrentUser) Color(0xFFD0E0FF) else Color(0xFFF0F0F0),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp)
        ) {
            Text(text = message.text)
        }
    }
}
