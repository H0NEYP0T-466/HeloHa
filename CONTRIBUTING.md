# Contributing to HeloHa 🤝

Thank you for your interest in contributing to HeloHa! We welcome contributions from developers of all skill levels. This document provides guidelines for contributing to make the process smooth and effective for everyone.

## 🚀 Quick Start

1. **Fork the repository** on GitHub
2. **Clone your fork** locally
3. **Create a feature branch** from main
4. **Make your changes** following our guidelines
5. **Test your changes** thoroughly
6. **Submit a pull request** with a clear description

## 📋 Table of Contents

- [🍴 Getting Started](#-getting-started)
- [🏗️ Development Setup](#️-development-setup)
- [📝 Code Style Guidelines](#-code-style-guidelines)
- [🧪 Testing](#-testing)
- [🐛 Bug Reports](#-bug-reports)
- [✨ Feature Requests](#-feature-requests)
- [📖 Documentation](#-documentation)
- [🔄 Pull Request Process](#-pull-request-process)
- [👥 Community Guidelines](#-community-guidelines)

## 🍴 Getting Started

### Prerequisites

Before contributing, ensure you have:

- **Android Studio** Arctic Fox or later
- **JDK 11** or later
- **Git** installed and configured
- **Firebase** project setup knowledge
- Basic understanding of **Kotlin** and **Jetpack Compose**

### Fork and Clone

```bash
# Fork the repository on GitHub, then:
git clone https://github.com/YOUR-USERNAME/HeloHa.git
cd HeloHa

# Add the original repository as upstream
git remote add upstream https://github.com/H0NEYP0T-466/HeloHa.git
```

### Create a Feature Branch

```bash
# Create and switch to a new branch
git checkout -b feature/your-feature-name

# Or for bug fixes
git checkout -b fix/issue-description
```

## 🏗️ Development Setup

### 1. Environment Setup

```bash
# Pull latest changes from upstream
git fetch upstream
git checkout main
git merge upstream/main

# Install dependencies (if any)
./gradlew build
```

### 2. Firebase Configuration

For development:
1. Create a test Firebase project
2. Configure Authentication, Realtime Database, and FCM
3. Download `google-services.json` to `app/` directory
4. **Never commit** your Firebase configuration files

### 3. IDE Setup

- **Code Style**: Import Android Studio Kotlin code style
- **Inspections**: Enable all Kotlin and Android lint checks
- **Formatting**: Use default Kotlin formatting rules

## 📝 Code Style Guidelines

### Kotlin Conventions

```kotlin
// ✅ Good - Clear class naming and structure
class MessageRepository {
    private val database = FirebaseDatabase.getInstance()
    
    suspend fun sendMessage(message: Message): Result<Unit> {
        // Implementation
    }
}

// ❌ Avoid - Poor naming and structure
class msg_repo {
    var db = FirebaseDatabase.getInstance()
    fun send(m: Message) { /* ... */ }
}
```

### Jetpack Compose Guidelines

```kotlin
// ✅ Good - Clear composable structure
@Composable
fun MessageItem(
    message: Message,
    isCurrentUser: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        // ...
    ) {
        // Content
    }
}

// ❌ Avoid - Unclear parameters and structure
@Composable
fun msg(m: Message, user: Boolean) {
    // Implementation
}
```

### File Organization

- **One class per file** (except for small data classes)
- **Package by feature** structure
- **Meaningful file names** that reflect content
- **Consistent imports** ordering

### Naming Conventions

- **Classes**: PascalCase (`MessageRepository`, `HomeScreen`)
- **Functions**: camelCase (`sendMessage`, `validateInput`)
- **Variables**: camelCase (`currentUser`, `messageText`)
- **Constants**: SCREAMING_SNAKE_CASE (`MAX_MESSAGE_LENGTH`)
- **Resources**: snake_case (`ic_send`, `color_primary`)

## 🧪 Testing

### Testing Requirements

All contributions should include appropriate tests:

```kotlin
// Unit test example
@Test
fun `validateMessage should return false for empty text`() {
    val result = MessageValidator.validate("")
    assertFalse(result.isValid)
}

// UI test example
@Test
fun loginScreen_displaysCorrectly() {
    composeTestRule.setContent {
        LoginScreen(navController = mockNavController)
    }
    
    composeTestRule
        .onNodeWithText("Login")
        .assertIsDisplayed()
}
```

### Running Tests

```bash
# Run unit tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest

# Run specific test class
./gradlew test --tests MessageValidatorTest
```

## 🐛 Bug Reports

When reporting bugs, please include:

### Required Information

- **Android version** and device model
- **App version** or commit hash
- **Steps to reproduce** the issue
- **Expected behavior** vs **actual behavior**
- **Screenshots** or **screen recordings** if applicable
- **Logs** from Android Studio or device

### Bug Report Template

```markdown
## Bug Description
Brief description of the issue

## Steps to Reproduce
1. Open the app
2. Navigate to...
3. Tap on...
4. Observe the issue

## Expected Behavior
What should happen

## Actual Behavior
What actually happens

## Environment
- Device: [e.g., Pixel 6]
- Android Version: [e.g., Android 13]
- App Version: [e.g., commit abc123]

## Additional Context
Any additional information, logs, or screenshots
```

## ✨ Feature Requests

We welcome feature suggestions! Please:

### Before Submitting

- **Check existing issues** to avoid duplicates
- **Consider the scope** - does it align with HeloHa's goals?
- **Think about implementation** - is it feasible?

### Feature Request Template

```markdown
## Feature Summary
Brief description of the proposed feature

## Motivation
Why is this feature needed? What problem does it solve?

## Detailed Description
Detailed explanation of how the feature should work

## Alternatives Considered
What alternatives have you considered?

## Additional Context
Mockups, examples, or related features
```

## 📖 Documentation

### Documentation Updates

When contributing code, also update:

- **README.md** if you add new features
- **Code comments** for complex logic
- **KDoc** for public APIs
- **CHANGELOG.md** for notable changes

### Documentation Style

```kotlin
/**
 * Sends a message to the group chat.
 *
 * @param message The message to send
 * @param userId The ID of the sending user
 * @return Result indicating success or failure
 * @throws NetworkException if network is unavailable
 */
suspend fun sendMessage(message: String, userId: String): Result<Unit>
```

## 🔄 Pull Request Process

### Before Submitting

1. **Test thoroughly** on different devices/screen sizes
2. **Run all tests** and ensure they pass
3. **Update documentation** as needed
4. **Rebase** your branch on latest main
5. **Review your changes** one final time

### Pull Request Template

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Testing
- [ ] Unit tests added/updated
- [ ] Manual testing completed
- [ ] Tested on multiple devices/screen sizes

## Screenshots (if applicable)
Add screenshots of UI changes

## Checklist
- [ ] Code follows style guidelines
- [ ] Self-review completed
- [ ] Documentation updated
- [ ] Tests added/updated
```

### Review Process

1. **Automated checks** must pass
2. **Code review** by maintainers
3. **Testing** on different configurations
4. **Approval** and merge

## 👥 Community Guidelines

### Code of Conduct

- **Be respectful** and inclusive
- **Provide constructive feedback**
- **Help newcomers** learn and contribute
- **Focus on the code**, not the person
- **Assume good intentions**

### Communication

- **Use clear, descriptive commit messages**
- **Respond promptly** to review feedback
- **Ask questions** if anything is unclear
- **Be patient** during the review process

### Commit Message Format

```bash
# Good commit messages
feat: add message reactions functionality
fix: resolve crash on empty message send
docs: update installation instructions
refactor: extract message validation logic

# Avoid
update stuff
fix bug
more changes
```

## 🎯 Contribution Ideas

Looking for ways to contribute? Consider:

### Beginner-Friendly
- **Fix typos** in documentation
- **Add unit tests** for existing functions
- **Improve error messages**
- **Add input validation**

### Intermediate
- **Implement new UI components**
- **Add accessibility features**
- **Optimize performance**
- **Add new authentication methods**

### Advanced
- **Implement end-to-end encryption**
- **Add offline support**
- **Create comprehensive testing framework**
- **Performance monitoring integration**

## 🆘 Getting Help

Need help with your contribution?

- **Check existing issues** and discussions
- **Read the documentation** thoroughly
- **Ask questions** in issue comments
- **Join community discussions**

## 📞 Contact

For major changes or questions about contributing:

- **Create an issue** for discussion
- **Email**: fezan1029@gmail.com
- **GitHub**: [@H0NEYP0T-466](https://github.com/H0NEYP0T-466)

---

**Thank you for contributing to HeloHa! Every contribution helps make the app better for everyone. 🚀**