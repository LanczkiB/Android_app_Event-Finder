# Android-
Android alkalmazás kotlinban

Mobil- és webes szoftverek című tárgy házi feladata.

Bemutatás

Az alkalmazás lehetővé teszi különféle csoportos, páros tevékenységek egyszerű és 
felhasználóbarát megtervezését. Az alkalmazás minden korosztály számára tartalmaz 
élménydús program ötleteket, legyen szó akár egy szülinapi zsúr helyszínéről vagy a 
nyugdíjasklub éves kirándulásáról Budapesten és környékén.

Az alkalmazás kitalálását az az elmélet ösztönözte, miszerint az emberek hajlamosak a jól 
bevált helyekre programokat szervezni ahelyett, hogy újakat próbálnának ki. Az alkalmazás 
összegyűjt sok lehetőséget, így időt és energiát spórol a felhasználóknak. Emellett számos 
magyar kisvállalkozás számára segíthet a Covid időszak utáni helyreállásban.


Főbb funkciók

Az alkalmazás kezdőképernyője a bejelentkezési képernyő, ahol a felhasználó a felhasználónév 
és a jelszó párossal tud belépni. 
Ezután a felhasználó előtt a különböző kategóriák jelennek meg (pl: Étkezés, Kirándulás, Egyéb). 
Ezek közül választva a következő Activity Recycler View segítségével listázza az egyes 
kategóriába tartozó tevékenységeket. A tevékenységhez tartozó „leírás” ikonra kattintva felugró 
DialogFragment jeleníti meg a program szöveges ismertetését. 
Ha a „leírás” ikon helyett a „hozzáadás”-ra kattint a felhasználó, akkor a következő Activity jelenik 
meg, ahol lehetősége van résztvevőket hozzáadni a programhoz, illetve időpontot választani. Itt 
a résztvevők törlésére is van lehetőség.
Ha a harmadik ikonra kattint (csillag), akkor pedig lehetősége van a felhasználónak a kedvencei 
közé tenni a tevékenységet.SnackBarjelzi a sikeres műveletet. A kedvenceket egy külön Activity 
listázza, amit a kategóriákat megjelenítő Activity-ről lehet elérni.
Az alkalmazás perzisztens adattárolást használ. 
