package com.example.pm01restapp22.process;

public class RestApiMethods
{

    public static final String ipaddress     = "192.168.124.217/";
    public static final String WebAPI        =  "PM01/";
    public static final String CreateEnpoint  =  "CrearAuto.php";
    public static final String ReadEnpoint  =  "ListaAutos.php";

    public static final String ApiCreate  =  "http://" + ipaddress + WebAPI + CreateEnpoint;
    public static final String ApiRead  =  "http://" + ipaddress + WebAPI + ReadEnpoint;

}
