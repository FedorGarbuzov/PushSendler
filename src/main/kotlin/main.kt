import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
            .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
            .putData("action", "LIKE")
            .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 3,
          "postAuthor": "Netology"
        }""".trimIndent())
            .setToken("cT5pWv4kRyy3rneHJhuXnK:APA91bGheMw-Dympi_ZdwpfmrcEUuzvxhGgXRy6XJRp95xVza-0mmEiUwXoJjPTWeZFyM8a5hEU1pQVpwTV4FXSSIYAKGEBuMCwWFDwtXpz9HwH0TeI3NQZRfAHCpE8GLFw5j-UYVlHS")
            .build()

    val message2 = Message.builder()
            .putData("action", "SHARE")
            .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 3,
          "postAuthor": "Netology"
        }""".trimIndent())
            .setToken("cT5pWv4kRyy3rneHJhuXnK:APA91bGheMw-Dympi_ZdwpfmrcEUuzvxhGgXRy6XJRp95xVza-0mmEiUwXoJjPTWeZFyM8a5hEU1pQVpwTV4FXSSIYAKGEBuMCwWFDwtXpz9HwH0TeI3NQZRfAHCpE8GLFw5j-UYVlHS")
            .build()

    val message3 = Message.builder()
            .putData("title", "Новое сообщение")
            .putData("content", "Иван оставил Вам сообщение")
            .setToken("cT5pWv4kRyy3rneHJhuXnK:APA91bGheMw-Dympi_ZdwpfmrcEUuzvxhGgXRy6XJRp95xVza-0mmEiUwXoJjPTWeZFyM8a5hEU1pQVpwTV4FXSSIYAKGEBuMCwWFDwtXpz9HwH0TeI3NQZRfAHCpE8GLFw5j-UYVlHS")
            .build()

    val message4 = Message.builder()
            .putData("action", "POST")
            .putData("content", """{           
          "author": "Vitaliy",
          "content": "Чтобы узнать, что должно случиться, достаточно проследить, что было. Это происходит от того, что все человеческие дела делаются людьми, которые имели и всегда будут иметь одни и те же страсти и поэтому неизбежно будут должны давать одни и те же результаты.(Никколо Макиавелли)",
          "published": "now"
          }""".trimIndent())
            .setToken("cT5pWv4kRyy3rneHJhuXnK:APA91bGheMw-Dympi_ZdwpfmrcEUuzvxhGgXRy6XJRp95xVza-0mmEiUwXoJjPTWeZFyM8a5hEU1pQVpwTV4FXSSIYAKGEBuMCwWFDwtXpz9HwH0TeI3NQZRfAHCpE8GLFw5j-UYVlHS")
            .build()

    FirebaseMessaging.getInstance().send(message)
}