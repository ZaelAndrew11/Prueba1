package cl.aguzman.prueba1;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import java.text.ParseException;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {
    public CalendarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Calendar
        final String nameUserInput = getActivity().getIntent().getExtras().getString("name");
        CalendarView calendarSign = (CalendarView) view.findViewById(R.id.calendarZodiac);
        calendarSign.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                int myMonth = month + 1;
                try {
                    compareSign(dayOfMonth, myMonth, nameUserInput);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        //calendar
    }

    //Validate Date
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void compareSign(int userday, int userMonth, String name) throws ParseException {
        SimpleDateFormat calendarDate = new SimpleDateFormat("dd-MM");
        String date = userday+"-"+userMonth;
        Date myDate = calendarDate.parse(date);

        Date acuario = calendarDate.parse("21-1");
        Date piscis = calendarDate.parse("19-2");
        Date aries = calendarDate.parse("21-3");
        Date tauro = calendarDate.parse("21-4");
        Date geminis = calendarDate.parse("21-5");
        Date cancer = calendarDate.parse("21-6");
        Date leo = calendarDate.parse("22-7");
        Date virgo = calendarDate.parse("22-8");
        Date libra = calendarDate.parse("23-9");
        Date escorpio = calendarDate.parse("21-10");
        Date sagitario = calendarDate.parse("21-11");
        Date capricornio = calendarDate.parse("22-12");

        int signAcuario = acuario.compareTo(myDate);
        int signPiscis = piscis.compareTo(myDate);
        int signAries = aries.compareTo(myDate);
        int signTauro = tauro.compareTo(myDate);
        int signGeminis = geminis.compareTo(myDate);
        int signCancer = cancer.compareTo(myDate);
        int signLeo = leo.compareTo(myDate);
        int signVirgo = virgo.compareTo(myDate);
        int signLibra = libra.compareTo(myDate);
        int signEscorpio = escorpio.compareTo(myDate);
        int signSagitario = sagitario.compareTo(myDate);
        int signCapricornio = capricornio.compareTo(myDate);


        if (signAcuario == 0 || signAcuario < 0 && signPiscis > 0) {
            toast(name, "Acuario");
        }

        if (signPiscis == 0 || signPiscis < 0 && signAries > 0) {
            toast(name, "Piscis");
        }

        if (signAries == 0 || signAries < 0 && signTauro > 0) {
            toast(name, "Aries");
        }

        if (signTauro == 0 || signTauro < 0 && signGeminis > 0) {
            toast(name, "Tauro");
        }

        if (signGeminis == 0 || signGeminis < 0 && signCancer > 0) {
            toast(name, "Geminis");
        }

        if (signCancer == 0 || signCancer < 0 && signLeo > 0) {
            toast(name, "Cancer");
        }

        if (signLeo == 0 || signLeo < 0 && signVirgo > 0) {
            toast(name, "Leo");
        }

        if (signVirgo == 0 || signVirgo < 0 && signLibra > 0) {
            toast(name, "Virgo");
        }

        if (signLibra == 0 || signLibra < 0 && signEscorpio > 0) {
            toast(name, "Libra");
        }

        if (signEscorpio == 0 || signEscorpio < 0 && signSagitario > 0) {
            toast(name, "Escorpion");
        }

        if (signSagitario == 0 || signSagitario < 0 && signCapricornio > 0) {
            toast(name, "Sagitario");
        }

        if (signCapricornio == 0 || signCapricornio < 0 && signAcuario < 0 || signAcuario > 0) {
            toast(name, "Capricornio");
        }
    }


    //Validate Date
    private void toast(String name, String signo) {
        AlertDialog.Builder windowModal = new AlertDialog.Builder(getActivity());
        windowModal.setTitle(name + " tu signo Zodiacal es");
        windowModal.setMessage(signo);
        windowModal.setPositiveButton("CERRAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        windowModal.show();

    }
}
