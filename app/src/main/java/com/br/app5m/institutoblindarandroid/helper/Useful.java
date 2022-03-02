package com.br.app5m.institutoblindarandroid.helper;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.br.app5m.institutoblindarandroid.R;


/**
 * Useful
 *
 * An class of Wesley Costa, for Android Studio 3.4.1 or newer
 *
 * @author Android version Wesley Costa
 * @since Version 4.1.0
 * @Created  06/2019 - 04/10/2019
 *
 * @Requered Java 8 && Androidx, daimajia
 */

public class Useful {

    public static final int NORMAL = 0;
    public static final int HOME = 1;
    private Context context;

    private static final String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm";
    private String currentPhotoPath;

    public Useful(Context context) {
        this.context = context;
    }

    /**
     * Este metodo constroi uma actionBar personalizada
     *
     * Params: activity, bar, title, type
     *
     * type 0 é pra qualquer activity
     * type 1 é pra apenas pra home activity
     *
     * você pode modifica-lo conforme a queira
     */

   /* public static void setActionBar(Activity activity, ActionBar bar , String title, int type){

        View view = activity.getLayoutInflater().inflate(R.layout.toolbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER
        );

        TextView textTitle = view.findViewById(R.id.textTitle);
        textTitle.setText(title);
        bar.setCustomView(view, params);

//        if (type == 0) {
//            bar.setHomeAsUpIndicator(activity.getResources().getDrawable(R.drawable.ic_arrow_back_toolbar, null));
//        }

        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayShowCustomEnabled(true);
        bar.setDisplayHomeAsUpEnabled(true);

    }*/

/*    public static void setActionBar(Activity activity, ActionBar bar , String title){

        View view = activity.getLayoutInflater().inflate(R.layout.toolbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER
        );

        TextView textTitle = view.findViewById(R.id.textTitle);
        textTitle.setText(title);
        bar.setCustomView(view, params);

        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayShowCustomEnabled(true);
        bar.setDisplayHomeAsUpEnabled(false);

    }*/


/*    //colocar circleimage view como parametro no back
    public static void setActionBarMenu(Activity activity, ActionBar bar, String name){

        View view = activity.getLayoutInflater().inflate(R.layout.toolbar_menu, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER
        );

        TextView textTitle = view.findViewById(R.id.nome_tv);
        ImageButton imageButton = view.findViewById(R.id.logout_imageButton);
        textTitle.setText(name);
        bar.setCustomView(view, params);

        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayShowCustomEnabled(true);
        bar.setDisplayHomeAsUpEnabled(false);

        imageButton.setOnClickListener(view1 -> activity.finish());

    }*/

//    public static void setActionBarChat(Activity activity, ActionBar bar, String title){
//
//        View view = activity.getLayoutInflater().inflate(R.layout.chat_toolbar, null);
//        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
//                ActionBar.LayoutParams.WRAP_CONTENT,
//                ActionBar.LayoutParams.WRAP_CONTENT
//        );
//
//        TextView textTitle = view.findViewById(R.id.textTitle);
//        textTitle.setText(title);
//        bar.setCustomView(view, params);
//
//        bar.setHomeAsUpIndicator(activity.getResources().getDrawable(R.drawable.ic_arrow_back_toolbar, null));
//
//        bar.setDisplayShowTitleEnabled(false);
//        bar.setDisplayShowCustomEnabled(true);
//        bar.setDisplayHomeAsUpEnabled(true);
//
//    }

    public static void startFragment(Fragment fragment, FragmentManager fragmentManager){
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    public static void startFragmentOnback(Fragment fragment, FragmentManager fragmentManager){
        fragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }


    /*
     *Faz a configuração do bitmap e o retorna em um tamanho menor
     *porem mantendo uma boa qualidade
     */
    public static BitmapFactory.Options bmOptions() {
        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = 3;
        bmOptions.inPurgeable = true;
        return bmOptions;
    }

    public static String picturePath(Context context, Intent data) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = context.getContentResolver().query(selectedImage,filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }

    public static boolean strongPassword(String password, int type) {
        boolean resultado = false;
        boolean achouNumero = false;
        /*boolean achouMaiuscula = false;
        boolean achouMinuscula = false;
        boolean achouSimbolo = false;*/
        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                achouNumero = true;
            } /*else if (c >= 'A' && c <= 'Z') {
                achouMaiuscula = true;
            } else if (c >= 'a' && c <= 'z') {
                achouMinuscula = true;
            } else {
                achouSimbolo = true;
            }*/

            if (type == 1) resultado = achouNumero;

            /*if (tipo == 2) resultado = achouMaiuscula;

            if (tipo == 3) resultado = achouMinuscula;

            if (tipo == 4) resultado = achouSimbolo;*/
        }
        return resultado;
    }

    public static boolean dataValida(@NonNull String string) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        if (string == null && string.length() != 10) return false;
        else {
            String separado[] = string.split("/");
            if (separado.length != 3) {
                return false;
            }
            int dia = Integer.parseInt(separado[0]);
            int mes = Integer.parseInt(separado[1]);
            int ano = Integer.parseInt(separado[2]);
            if (dia >= 1 && dia <= 31) check1 = true;
            if (mes >= 1 && mes <= 12) check2 = true;
            if (ano >= 1900 && mes <= 2050) check3 = true;
        }
        return check1 && check2 && check3;
    }

    public static String titleCase(String str) {
        if (str == null) return "";
        if (str.length() < 1) return str;

        String[] words = str.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
            sb.append(" ");
        }
        return sb.toString();
    }

//    public static boolean isOnline(Context context) {
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo netInfo = cm.getActiveNetworkInfo();
//        return netInfo == null || !netInfo.isConnected();
//    }



    //recupera a data atual
    public static String dataAtual(){
        String dataFormatada = "";
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        dataFormatada = formataData.format(data);
        return dataFormatada;
    }

    public static String addMask(final String textoAFormatar, final String mask){
        String formatado = "";
        int i = 0;
        // vamos iterar a mascara, para descobrir quais caracteres vamos adicionar e quando...
        for (char m : mask.toCharArray()) {
            if (m != '#') { // se não for um #, vamos colocar o caracter informado na máscara
                formatado += m;
                continue;
            }
            // Senão colocamos o valor que será formatado
            try {
                formatado += textoAFormatar.charAt(i);
            } catch (Exception e) {
                break;
            }
            i++;
        }
        return formatado;
    }

    public static String validateMoneyText(EditText amountEdit, Locale mLocale){

        String valor = amountEdit.getText().toString();
        String s;
        try {
            s = DecimalFormat.getCurrencyInstance(mLocale).parse(valor).toString();
        } catch (ParseException e) {
            return null;
        }

        double aux = Double.parseDouble(s);

        return String.valueOf(aux).replace(".", ",");
    }

    public static void openPdf(Activity activity, String filename){
        File pdfFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/MegaZoo/"+ filename);  // -> filename = maven.pdf
        Uri path = FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".br.com.app5m.appmegazoo.helper.provider", pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Intent intent = Intent.createChooser(pdfIntent, "Open File");

        try{
            activity.startActivity(intent);
        }catch(ActivityNotFoundException e){
            Toast.makeText(activity, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

//    public Object parcelToObjectModel(List<Object> objectList) {
//
//        Object object = new Object();
//
//
//
//        return object;
//    }
}

