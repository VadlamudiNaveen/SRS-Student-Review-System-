package info.androidhive.firebase.messaging;

import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import info.androidhive.firebase.R;
import info.androidhive.firebase.list_of_surveys.List_it;
//import info.androidhive.firebase.survey_data_form.Survey_form;

public class MessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        Intent tent=new Intent(this, List_it.class);
        startActivity(tent);;
    }
    public void showNotification(String title,String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "mynotifications")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_light_normal_background)
                .setAutoCancel(true)
                .setContentText(message);
        NotificationManagerCompat manager= NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());
    }
}
