package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Butonları ve edittexti oluşturabilmek için gerekli değişkenlerin tanımlanması.
    Button
            btnArti,
            btnEksi,
            btnCarpi,
            btnBolu,
            btnArtiEksi,
            btnSifir,
            btnNokta,
            btnClear,
            btnBir,
            btnIki,
            btnUc,
            btnEsittir,
            btnDort,
            btnBes,
            btnAlti,
            btnYedi,
            btnSekiz,
            btnDokuz;
    EditText sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnArti=findViewById(R.id.btnArti);
        btnEksi=findViewById(R.id.btnEksi);
        btnCarpi=findViewById(R.id.btnCarpi);
        btnBolu=findViewById(R.id.btnBolu);
        btnArtiEksi=findViewById(R.id.btnArtiEksi);
        btnSifir=findViewById(R.id.btnSifir);
        btnNokta=findViewById(R.id.btnNokta);
        btnClear=findViewById(R.id.btnClear);
        btnBir=findViewById(R.id.btnBir);
        btnIki=findViewById(R.id.btnIki);
        btnUc=findViewById(R.id.btnUc);
        btnEsittir=findViewById(R.id.btnEsittir);
        btnDort=findViewById(R.id.btnDort);
        btnBes=findViewById(R.id.btnBes);
        btnAlti=findViewById(R.id.btnAlti);
        btnYedi=findViewById(R.id.btnYedi);
        btnSekiz=findViewById(R.id.btnSekiz);
        btnDokuz=findViewById(R.id.btnDokuz);
        //Edittextte hesaplamalarımızı gördüğümüz kısım.
        sonuc=(EditText)findViewById(R.id.HesapEkrani);
    }

    //Texti temizleme butonu
    public void Temizle(View view)
    {
        sayi=null;
        ilkSayi=0;
        sonSayi=0;
        sonuc.setText(String.valueOf(0));
    }

    String sayi=null;

    //Bir sayıya tıklayıp daha sonra +/- operatörüne tıkladığımızda sayı negatif ise pozitife dönmesini sağlar.
    //Bir sayıya tıklayıp daha sonra +/- operatörüne tıkladığımızda sayı pozitif ise negatife dönmesini sağlar.
    //Ama sayı sıfır ise herhangi bir işaret ataması yapılmaz.
    public void Pozitif_Negatif()
    {
        sonSayi=Double.parseDouble(sonuc.getText().toString());
        ilkSayi=(-1)*sonSayi;
        sonuc.setText(""+ilkSayi);
    }

    public void btnPozitifNegatif(View view)
    {
        if(sayi!=null)
        {
            Pozitif_Negatif();
            if(sonSayi==0)
            {
                sonuc.setText("0");
                sayi=null;
            }

        }

    }

    //Nokta metodu ondalıklı sayılar yazmak için gereken metod.
    public void Nokta()
    {
        sonuc.setText(sonuc.getText()+".");
    }

    //Bütün sayı butonlarımızı buraya yönlendirdik.
    public void sayi_Click(View view)
    {
        if(sayi==null)
        {
            sayi=view.getTag().toString();
            if(durum=="nokta")
            {
                if(operator)
                    Nokta();
                operator=false;
            }
        }
        else
        {
            if(durum=="nokta")
            {
                if(operator)
                {
                    //Nokta işaretine basıldıktan sonra sağına sayı ekleme işlemi.
                    Nokta();
                    sayi=sayi+view.getTag().toString();
                }
                operator=false;

            }
            else
            {
                sayi=sayi+view.getTag().toString();
            }
        }
        operator=true;
        sonuc.setText(sayi);
    }

    double ilkSayi=0;
    double sonSayi=0;
    boolean operator=false;
    String durum=null;

    //Gerçek hesap makinesindeki gibi bir sayı girip arasına + koyup diğer sayıyı girdiğimizde çarpıya veya herhangi
    //bir operatöre bastığımızda toplama işlemini yapmaktadır.

    //Mesela 2+7 yaptığımda sonucu 9 vermesi lazım hangi operatöre basarsam basayım fark etmemesi lazım.
    public void Topla()
    {
        sonSayi=Double.parseDouble(sonuc.getText().toString());
        ilkSayi=ilkSayi+sonSayi;
        sonuc.setText(""+ilkSayi);
    }
    public void btnTopla(View view)
    {

        if(durum=="carp")
        {
            if(operator)
                Carp();
        }
        else if(durum=="bol")
        {
            if(operator)
                Bol();
        }
        else if(durum=="cikar")
        {
            if(operator)
                Cikar();
        }
        else
        {
            if(operator) 
                Topla();
        }

        durum="topla";
        sayi=null;
        operator=false;
    }

    //Mesela 2+7 yaptığımda sonucu 9 vermesi lazım hangi operatöre basarsam basayım fark etmemesi lazım.
    //9 sonucunu almadan önce * (çarpı) işaretine basarsam ve sonrasında mesela 2 girdiğimi düşünelim
    //sonucu 18 olarak vermesi gerekmektedir.
    public void Carp()
    {
        //ilksayiyi yukarda sıfır(0) belirttiğimiz için 0*X=0 oluyor.Bu yüzden ilksayi=1; yapmamız gerekiyor.
        if(ilkSayi==0)
            ilkSayi=1;
        sonSayi=Double.parseDouble(sonuc.getText().toString());
        ilkSayi=ilkSayi*sonSayi;
        sonuc.setText(""+ilkSayi);
    }
    public void btnCarp(View view)
    {

        if(durum=="topla")
        {
            if(operator)
                Topla();
        }
        else if(durum=="bol")
        {
            if(operator)
                Bol();
        }
        else if(durum=="cikar")
        {
            if(operator)
                Cikar();
        }
        else
        {
            if(operator)
                Carp();
        }

        durum="carp";
        sayi=null;
        operator=false;
    }

    //Bölme işlemi metodum da diğer metodlarda olduğu gibi aynı mantıkta çalışmaktadır.Mesela öncesinde toplama işlemi
    // ya da herhangi başka bir işlem yapıldıktan sonra bölme işlemini yapabilmektedir.
    public void Bol()
    {
        sonSayi=Double.parseDouble(sonuc.getText().toString());
        ilkSayi=ilkSayi/sonSayi;
        sonuc.setText(""+ilkSayi);
    }
    public void btnBol(View view)
    {
        if(durum=="topla")
        {
            if(operator)
                Topla();
        }
        else if(durum=="carp")
        {
            if(operator)
                Carp();
        }
        else if(durum=="cikar")
        {
            if(operator)
                Cikar();
        }
        else
        {
            if(operator)
                Bol();
        }

        durum="bol";
        sayi=null;
        operator=false;
    }

    public void Cikar()
    {
        //Çıkarma işlemi metodu.
        sonSayi=Double.parseDouble(sonuc.getText().toString());
        ilkSayi=sonSayi-ilkSayi;
        sonuc.setText(""+ilkSayi);
    }
    public void btnCikar(View view)
    {
        if(durum=="topla")
        {
            if(operator)
                Topla();
        }
        else if(durum=="carp")
        {
            if(operator)
                Carp();
        }
        else if(durum=="bol")
        {
            if(operator)
                Bol();
        }
        else
        {
            if(operator)
                Cikar();
        }
        durum="cikar";
        sayi=null;
        operator=false;
    }

    public void btnEsittir(View view)
    {
        //Burada en son yani sonSayi girildikten sonra normalde bir operatöre basıp cevap alıyorduk.
        //Bunu eşittir ile tüm operatörler için yapmamız gerekiyor.
        //Yani herhangi bir işlemi yaptıktan sonra eşittire basarak sonuç alabiliyoruz.
        if(operator==true)
        {
            if(durum=="topla")
                ilkSayi=ilkSayi+Double.parseDouble(sonuc.getText().toString());
            //En son alınan cevap ile yeni girilen sayıyı editTextten bulunan sayıya yollladık.
            if(durum=="carp")
                ilkSayi=ilkSayi*Double.parseDouble(sonuc.getText().toString());
            if(durum=="bol")
                ilkSayi=ilkSayi/Double.parseDouble(sonuc.getText().toString());
            if(durum=="cikar")
                ilkSayi=ilkSayi-Double.parseDouble(sonuc.getText().toString());
            sonuc.setText(""+ilkSayi);
        }
        operator=false;
    }


}