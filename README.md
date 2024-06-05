
# Basic Chat App

The Chat App is designed to simulate a chat environment, allowing users to interact with a sample dataset of chat messages. It provides a platform to explore and understand the implementation of chat-related features within an Android application. The app utilizes Jetpack Compose, ViewModel, and Retrofit technologies to provide a smooth and efficient user experience.

## Features

- Chat Screen: Users can view a list of chat messages, including the sender's name, message content, and timestamp.
-	Message Input: Users can input new messages through a text input field and send them to the chat.
-	Error Handling: The app handles errors gracefully and displays error messages when necessary.
-	Networking: The app fetches dummy chat messages from a public API using Retrofit, ensuring seamless integration with external data sources.
-	User Interaction: Users can perform actions such as editing or deleting messages through intuitive gestures like long-press and double-tap.
-	Theme Support: The app supports dark and light themes, changing colors accordingly to enhance user experience.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine.


### Prerequisites

- Android Studio 4.0 or higher
- Android SDK
- Kotlin 1.4 or higher


#### Installing

1. **Clone the repository:**
   Open a terminal and run the following command:

   ```sh
   git clone https://github.com/amEya911/BasicChatScreen.git
   

2. **Open the project in Android Studio:**
    Open Android Studio and select Open an existing project. Navigate to the directory where you cloned the repository and select the BasicChatScreen folder.

3. **Build the project:**
    Once the project is opened, Android Studio will start syncing and downloading all the required dependencies. If it doesn't start automatically, you can manually sync the project by clicking on File >        Sync Project with Gradle Files.

4. **Set up an emulator or connect a physical device:**
    - Emulator: To run the app on an emulator, you need to create a virtual device. Go to Tools > AVD Manager, click on Create Virtual Device, choose a device definition and a system image, then follow the     steps to complete the setup.
    - Physical Device: To run the app on a physical device, ensure that USB debugging is enabled on your device and it is connected to your computer via USB.
  
5. **Run the project:**
    After setting up an emulator or connecting a physical device, click the Run button (green play button) in Android Studio. Choose your emulator or physical device as the deployment target. The app should     build and launch on the selected device.


## How to Use

1.	Open the Chat App on your device.
2.	The main screen displays a list of chat messages.
3.	To send a new message, type your message in the text input field and tap the send button.
4.	To edit or delete a message, long-press the message and select the desired action from the context menu.
5.	To add reactions to a message, double tap the message and select the emoji to add
6.	Enjoy seamless communication with other users in real-time!


## Acknowledgements and Mentions

-   Jetpack Compose: The app's user interface is built using Jetpack Compose, making it easy to create dynamic and engaging user interfaces.
-	ViewModel Library: Utilized to manage UI-related data in a lifecycle-conscious way, ensuring a smooth user experience.
-   Retrofit: Used for networking tasks, enabling the app to fetch and display dummy chat messages from a public API.

  
## Technical Flow

1.	Networking:
-	The app initiates network requests using Retrofit to fetch dummy chat messages from a public API. Retrofit handles the HTTP requests and responses, ensuring seamless integration with external data sources.
2.	Data Processing:
-	Upon receiving the response from the API, the app processes the retrieved data using ViewModel. It manages the message data, including parsing and mapping it to appropriate data structures for display on the user interface.
3.	Message Management:
-	Users can interact with the app by sending, editing, or deleting messages. ViewModel facilitates real-time updates to the message list based on user actions, ensuring changes are reflected instantly on the chat screen.
4.	Error Handling:
-	The app gracefully handles any errors that may occur during the network request process or data processing. It displays error messages to users when necessary, providing a smooth and reliable user experience.

 -  ![image_2024-06-05_204040237](https://github.com/amEya911/BasicChatScreen/assets/112489532/643a1b46-f9f0-4525-b770-3523d3811b1a)

## Future Enhancements

-   User Authentication: Implement user authentication to enable secure communication between authenticated users.
-   Message Filtering: Introduce features for filtering and searching messages to enhance user experience.
-	Notification System: Implement a notification system to alert users of new messages or important updates.
-	Customization Options: Allow users to customize the app's interface and personalize their chat experience.
-	Enhanced Security: Implement encryption and other security measures to protect user data and ensure privacy.

## Screenshots
![WhatsApp Image 2024-06-05 at 4 57 11 PM](https://github.com/amEya911/BasicChatScreen/assets/112489532/6de0758c-82d6-42b9-8df0-8551cbf02544)


