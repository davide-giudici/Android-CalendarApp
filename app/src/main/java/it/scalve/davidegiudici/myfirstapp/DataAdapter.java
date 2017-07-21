package it.scalve.davidegiudici.myfirstapp;

/**
 * Created by davide.giudici on 12/06/2015.
 */
public class DataAdapter {

    private String NOTTE_CORTA = "00:00 - 08:30";
    private String NOTTE_LUNGA = "00:00 - 10:00";
    private String POMERIGGIO  = "10:00 - 18:00";
    private String POME_TARDI  = "14:00 - 20:30";
    private String SERA        = "18:00 - 00:00";
    private String EQUIPE_MAT  = "09:30 - 12:30";
    private String GIORNO      = "08:30 - 18:00";
    private String NO_LAVORO   = "CASA";

    private String[][] turniFissi = new String[][]
    {
        /*    LUNEDI         MARTEDI             MERCOLEDI                  GIOVEDI          VENERDI       SABATO           DOMENICA */
         { // I Settimana
            NO_LAVORO,      POME_TARDI,     EQUIPE_MAT,                     NO_LAVORO,      POMERIGGIO,     SERA,           NOTTE_CORTA,
        },
        { // II Settimana
            POMERIGGIO,     NO_LAVORO,      EQUIPE_MAT,                     NO_LAVORO,      POME_TARDI,     GIORNO,         NO_LAVORO,
        },
        { // III Settimana
            NO_LAVORO,      SERA,           "00:00 - 12:30" ,               POMERIGGIO,     POME_TARDI,     NO_LAVORO,      NO_LAVORO,
        },
        { // VI Settimana
            POMERIGGIO,     POME_TARDI,     EQUIPE_MAT + " " + POME_TARDI, NO_LAVORO,      SERA,           NOTTE_CORTA,    NO_LAVORO,
        },
        { // V Settimana
            NO_LAVORO,      NO_LAVORO,      EQUIPE_MAT,                     POMERIGGIO,     SERA,           NOTTE_CORTA,    GIORNO,
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
