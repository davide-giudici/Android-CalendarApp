package it.scalve.davidegiudici.myfirstapp;

/**
 * Created by davide.giudici on 12/06/2015.
 */
public class DataAdapter {

    private String NOTTE_CORTA = "00:00 - 08:30";
    private String NOTTE_LUNGA = "00:00 - 10:00";
    private String POMERIGGIO = "10:00 - 18:00";
    private String POMERIGGIO_TARDI = "14:00 - 20:30";
    private String SERA = "18:00 - 00:00";
    private String EQUIPE = "09:30 - 12:30";
    private String GIORNO = "08:30 - 18:00";
    private String CASA = "CASA";

    private String[][] turniFissi = new String[][]
    {
        /*    LUNEDI         MARTEDI             MERCOLEDI                        GIOVEDI          VENERDI                SABATO           DOMENICA */
                           
        // I Settimana     
        {                  
            CASA,          POMERIGGIO_TARDI,      EQUIPE,                          CASA,           POMERIGGIO,             SERA,             NOTTE_CORTA,
        },                 
                           
        // II Settimana    
        {                  
            POMERIGGIO,    CASA,                   EQUIPE,                         CASA,           POMERIGGIO_TARDI,      GIORNO,           CASA,
        },                 
                           
        // III Settimana   
        {                  
            CASA,          SERA,                  "00:00 - 12:30" ,                POMERIGGIO,      POMERIGGIO_TARDI,      CASA,              CASA,
        },                 
                           
        // VI Settimana    
        {                  
            POMERIGGIO,    POMERIGGIO_TARDI,      EQUIPE + " " + POMERIGGIO_TARDI, CASA,            SERA,                  NOTTE_CORTA,          CASA,
        },                 
                           
        // V Settimana     
        {                  
            CASA,          CASA,                  EQUIPE ,                         POMERIGGIO,      SERA,                  NOTTE_CORTA,        GIORNO,
        },
    };

    public String getTurnoDescription(int week, int day)
    {
        if (week <= 0 || week > 5)
            return "ERRORE SETTIMANA";
        if (day <= 0 || day > 7)
            return "ERRORE GIORNO";

        return turniFissi[--week][--day];
    }
}
