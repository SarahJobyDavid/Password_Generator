# Password Generator

A simple and secure GUI-based password generator built in Java to create strong, random passwords for your accounts. This application allows users to customize password length and include/exclude uppercase letters, lowercase letters, numbers, and special symbols via an intuitive interface.

## Features

- Customizable password length (user input).
- Toggle options for uppercase letters, lowercase letters, numbers, and special symbols.
- Real-time password generation with validation (requires length > 0 and at least one character type selected).
- Scrollable output area for displaying the generated password.
- Clean, centered GUI design with a pink-themed interface for better user experience.

## Installation

1. Clone the repository:
   ```
   git clone https://github.com/SarahJobyDavid/Password_Generator.git
   ```

2. Navigate to the project directory:
   ```
   cd Password_Generator
   ```

3. Compile the Java source files:
   ```
   javac *.java
   ```

*Note: This project uses only standard Java libraries (Swing and AWT), so no external dependencies are needed. Requires Java 8 or higher.*

## Usage

1. Run the application:
   ```
   java App
   ```

2. In the GUI:
   - Enter the desired password length in the input field.
   - Toggle the checkboxes for UpperCase, LowerCase, Numbers, and/or Symbols to include those character types.
   - Click the "Generate" button to create and display the password in the output area.

Example:
- Input length: 12
- Selected: UpperCase, LowerCase, Numbers, Symbols
- Output: Something like `A7#kP9mX2$qR`

The password is generated randomly from the selected character sets and displayed immediately.

## How It Works

The backend (`PasswordGenerator` class) combines the selected character sets (uppercase, lowercase, numbers, symbols) into a pool and randomly selects characters to build the password of the specified length using Java's `Random` class.

The frontend (`PasswordGeneratorGUI` class) handles user input via toggles and text fields, validates selections, and triggers generation on button click. The main entry point is `App.java`.

## Technologies Used

- Java 8+
- Swing (for GUI components)
- AWT (for layout and event handling)

Project Link: [https://github.com/SarahJobyDavid/Password_Generator](https://github.com/SarahJobyDavid/Password_Generator)
