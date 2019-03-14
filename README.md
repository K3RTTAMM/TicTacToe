# TicTacToe

Mobiilirakenduste Arendamine 1. Iseseisev Töö - Kert Tamm

### Viide Juhendile
Kasutatud allikad: 
https://codinginflow.com/tutorials/android/tic-tac-toe/
https://stackoverflow.com/

### Projekti seadistamine

Esialgselt sai seadistatud töötamaks API level 24 (Android 7.0), kuid sai hiljem muudetud API level 23 (Android 6.0).

### Arvamus juhendist (min 2 lõiku).
Juhend oli suhteliselt hea ja arusaadav, mõne asjaga läks küll aega enne kui sain aru mida miski täpsemalt teeb, aga põhiasjad olid ilusti videodes ära seletatud. Juhend võiks olla natukene parem selles mõttes, et button elemendid ei tohiks olla borderitega, vaid hea oleks, kui oleks borderi asemel tehtud mingil muul paigutamise viisil. Ka Android Studio nuriseb selle üle kui on borderid paigutatud.

### Kirjeldatakse vajalikest muutustest seoses SDK versiooni muutustega.
Kuna mul oli juba enda arvutis Android Studio ja vajalikud SDK ning NDK versioonid varasemalt installitud/seadistatud oma arvutis GameMaker Studio 2 jaoks ja Android Studios sellega loodud mängude .apk'de virtuaalmasinates testimiseks, siis polnud lisasätteid vaja teha, et projekt töötaks.

### Kirjeldus juhendi muudest muutustest rakenduse terviklikumaks muutmiseks.
Peale juhendi järgi rakenduse tööle saamist hakkasin muutma erinevaid aspekte. Proovisin algul lisada ka startmenüü funktsiooni, et mängija saaks näiteks valida kumb alustab, või kasvõi nimede sisestamise, aga pikema pusimise järel ei saanud ikkagi seda funktsionaalsust tööle. 
Sai lisatud ka tekst "turn" mängija nime taha, et oleks näha millise mängija kord parasjagu käes on. Lisaks sellele sai ka lisatud väike loogikaelement, et kui Player 1 võidab, siis alustab Player 2 ja teisel juhul vastupidi. Lisasin trips-traps-trulli ruudustikule taustapildid, mille background tint värvi muutes saab kergelt muuta ka ruudustiku värve. Muutsin rakenduse värvide ja font elemente ning sai tehtud ka koodi veidi puhtamaks ja eemaldatud hardcoded text nuppudelt.
