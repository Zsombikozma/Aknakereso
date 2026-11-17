package AKNAKERESO;

public class Aknakereso {
    private char[][] tabla;
    private boolean[][] feltart;
    private boolean vege;
    private int biztonsagosMezok;
    private int feltartMezok;
    private int sor;
    private int oszlop;

    public Aknakereso(char[][] tabla) throws AknakeresoException {
        if (tabla == null || tabla.length == 0) {
            throw new AknakeresoException("A tábla nem lehet üres");
        }

        this.sor = tabla.length;
        this.oszlop = tabla[0].length;

        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] == null || tabla[i].length != oszlop) {
                throw new AknakeresoException("Nem téglalapalakú");
            }
            for (int j = 0; j < tabla[i].length; j++) {
                if (tabla[i][j] != 'a' && tabla[i][j] != '0') {
                    throw new AknakeresoException(
                            "Nem megfelelő karakter a táblán: " + tabla[i][j]);
                }
            }
        }

        this.tabla = new char[sor + 2][oszlop + 2];
        for (int i = 0; i < sor + 2; i++) {
            for (int j = 0; j < oszlop + 2; j++) {
                this.tabla[i][j] = 'l';
            }
        }

        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                this.tabla[i + 1][j + 1] = tabla[i][j];
            }
        }

        for (int i = 1; i <= sor; i++) {
            for (int j = 1; j <= oszlop; j++) {
                if (this.tabla[i][j] == '0') {
                    int db = 0;
                    if (this.tabla[i - 1][j - 1] == 'a') db++;
                    if (this.tabla[i - 1][j] == 'a') db++;
                    if (this.tabla[i - 1][j + 1] == 'a') db++;
                    if (this.tabla[i][j - 1] == 'a') db++;
                    if (this.tabla[i][j + 1] == 'a') db++;
                    if (this.tabla[i + 1][j - 1] == 'a') db++;
                    if (this.tabla[i + 1][j] == 'a') db++;
                    if (this.tabla[i + 1][j + 1] == 'a') db++;

                    this.tabla[i][j] = (char) ('0' + db);
                    biztonsagosMezok++;
                }
            }
        }

        char[][] tiszta = new char[sor][oszlop];
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                tiszta[i][j] = this.tabla[i + 1][j + 1];
            }
        }
        this.tabla = tiszta;

        this.feltart = new boolean[sor][oszlop];
        this.feltartMezok = 0;
        this.vege = false;
    }

    public String tipp(int x, int y) throws AknakeresoException {
        if (vege) {
            throw new AknakeresoException("A játék már véget ért");
        }
        if (x < 0 || x >= sor || y < 0 || y >= oszlop) {
            throw new AknakeresoException("A koordináták a táblán kívül vannak");
        }
        if (tabla[x][y] == 'a') {
            vege = true;
            return "Aknára léptél";
        }

        if (!feltart[x][y]) {
            feltart[x][y] = true;
            feltartMezok++;
        }

        if (feltartMezok == biztonsagosMezok) {
            vege = true;
            return "Megnyerted a játékot! Az utolsó mező száma: " + tabla[x][y];
        }

        return "Nem akna és ennyi akna van mellette: " + tabla[x][y];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                sb.append(tabla[i][j]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}