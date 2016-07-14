/**
  * Created by a.shipulin on 08.07.16.
  */
import javax.mail._
import javax.mail.internet._
import java.util._

object GmailSenderSimple extends App {
  if(args.size < 2) {
    println("Usage: gmail-sender-simple gmail-user gmail-password")
    sys.exit(1)
  }

  val Array(username, password, _*) = args
  // SAG -->

/*  val myaddress = new Address {

    override def getType: String = "a.shipulin@ckbran.ru"
    override def toString: String
  }
  */

  val addressArr  =new Array[Address](1)
  addressArr(0) = new InternetAddress("shsanya@inbox.ru")




  //val mymessage = new Message() {}
  // <--

  val properties = new Properties()
  properties.put("mail.smtp.host", "mail.ckbran.ru")
  properties.put("mail.smtp.starttls.enable","true")
  properties.put("mail.smtp.ssl.trust", "mail.ckbran.ru");
  val session = Session.getDefaultInstance(properties)
  val message = new MimeMessage(session)

  message.addFrom(addressArr)
  message.addRecipients(Message.RecipientType.TO,
    s"User Name <$username>")
  message.setSubject("Greetings!")
  message.setText("Hello!")




  //Transport.send(message, username, password)
  Transport.send(message)
}
