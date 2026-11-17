# Aknakereső

Egyszerűsített aknakereső játék Java nyelven, konzolos kezeléssel.

## Leírás

A játék egy kétdimenziós `char` tömbből indul, amiben `'a'` jelöli az aknát,
`'0'` az üres mezőt. A konstruktor ellenőrzi a táblát, majd minden üres
mező helyére beírja a szomszédos aknák számát. A `tipp(x, y)` metódussal
lehet mezőket felfedni.

## Funkciók

- tábla ellenőrzése (csak `'a'` és `'0'` engedélyezett, téglalap alakú)
- szomszédos aknák számolása keretes segédtáblával
- `AknakeresoException` saját kivétel hibás táblára és hibás tippre
- nyerés és vesztés felismerése
- tippelés Scannerrel a konzolról

## Fájlok

| Fájl | Szerepe |
|---|---|
| `Jatek.java` | a játék logikája |
| `AknakeresoException.java` | saját kivétel |
| `Jmain.java` | futtatható példa, beolvasás Scannerrel |

## Futtatás

```
javac ZH/*.java
java ZH.Jmain
```

A tippet `sor oszlop` formában kell megadni, például `1 2`.

## Példa

```
Sor és oszlop (pl. 1 2): 2 0
Nem akna és ennyi akna van mellette: 0
Sor és oszlop (pl. 0 1): 0 1
Aknára léptél
```

## Használt technológiák

Java (OOP, kivételkezelés, kétdimenziós tömbök)