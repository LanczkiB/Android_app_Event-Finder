package hu.bme.aut.hazi

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import hu.bme.aut.hazi.data.UserListDatabase
import hu.bme.aut.hazi.data.entities.ActivityItem
import hu.bme.aut.hazi.data.entities.UserItem
import hu.bme.aut.hazi.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: UserListDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = UserListDatabase.getDatabase(applicationContext)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

thread {
    if(database.UserItemDao().getAllUsers().isEmpty()){
        database.UserItemDao().insertUser(UserItem(1, "user", "1"))
        database.UserItemDao().insertActivity(ActivityItem(1, "Semmi Extra", "A Semmi Extra étterem gondolata négy barát fejéből pattant ki 11 évvel ezelőtt a Velencei-tó partján. Azóta töretlen lendülettel dolgozunk azon, hogy olyan helyet hozzunk létre számotokra, ahol jól tudjátok érezni magatokat a barátaitokkal, egy pohár sörrel a kezetekben vagy a család minden tagjával egy vasárnapi ebéd alkalmával is.",
                R.drawable.semmiextra, 1,"", ""))
        database.UserItemDao().insertActivity(ActivityItem(2, "Bölcső Bar & Food", "A helyi kocsmád vagyunk Újbudán, válogatott jó sörökkel és ételekkel. Gasztropub=Egy kocsma, ahol enni is tudsz.",
                R.drawable.bolcso, 1, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(3, "Trófea", "A Trófea 2020-ban is elnyerte a Superbrands díjat. Ami nemzetközi színvonalon elég jelentős érdemnek számít, mind a szakmának mind a vendégek számára. Az étteremek a vendégeinek a megbízható garanciát és a kiváló minőséget jelenti a védjegy.",
                R.drawable.trofea, 1, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(4, "Bajor", "A Bajor Söröző egy kedves kis kocsma a Móricz Zsigmond körtér közelén.A burger mesés,kézműves sörért pedig gyakran visszajárnak a vendégek!",
                R.drawable.bajor, 1, "", ""))
        ItemManager.users = database.UserItemDao().getAllUsers()
        database.UserItemDao().insertActivity(ActivityItem(5, "Csendes Létterem", "2008-ban nyitotta meg „újra” kapuját a Múzeum körút 13. szám alatt található a régen, erdélyi étteremként működő Csendes. Az új köntösbe bújtatott enteriőr, az állandóan cserélődő zenei és egyéb programok, a hatalmas italválaszték, a fiatalos lendület alapozza meg a hely szellemét. ",
                R.drawable.csendes, 2, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(6, "Füge Udvar", "Burgereket és csapolt sört kínáló kedélyes romkocsma játékgépekkel, tánctérrel és sörkerttel.",
                R.drawable.fuge, 2, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(7, "A Grund", "Fények, zene, grillkonyha és változatos zenei programok a tisztelt nagyérdemű szíve útját keresve. „Nemhiszedel” kategóriában: Budapest egyetlen szórakoztatóipari eperfája, amelyet egy szabálytalan építészeti megoldással mentettünk meg a kivágástól, néha be is ázunk. Nem baj. Körülöttünk új és magas házak vannak, a mieink meg régiek és alacsonyak. Játszótérrel várjuk a kicsiket és a nagyokat is.",
            R.drawable.grund, 2, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(8, "Cinema City Mozi", "A Cinema City egy vezető magyar multiplex mozi lánc, és a legjobb módja annak, hogy nézzen egy filmet.",
            R.drawable.cinemacity, 4, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(9, "Új Színház", "Az Új Színház, 2012-től megnevezése Újszínház Budapest színházainak egyike, a Paulay Ede utcában. 1961-tól gyermek- és ifjúsági színházként működött, majd 1994-ben Székely Gábor vezetésével profiljában és nevében is megújult. Fővárosi fenntartású kőszínház.",
            R.drawable.ujszinhaz, 4, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(10, "Cyber Jump", "Családi szabadidőközpont trambulinokkal, kosárpalánkokkal, valamint mászófallal és szivacsmedencékkel.",
            R.drawable.cyber, 4, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(11, "Strike Bowling","1997-ben nyitottuk meg a Strike Bowling Club és Éttermet.Létesítményünk nyolc automata bowling pályával és saját konyhával működik.Klubunk barátságos, családias hangulatáról híres.A család együttsportolását gyerekpálya kialakításával és könnyített gyerek-golyókkal kívánjuk biztosítani.",
            R.drawable.bowling, 4, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(12, "Piknik a Margit-szigeten","A Duna Buda és Pest közötti részén elterülő, zöldellő Margitsziget nyugodt oázis a városban. A ligetet, a szecessziós víztornyot, egy 13. századból fennmaradt domonkos rendi kolostor romjait, a zenélő szökőkutat, valamint a szerény vadasparkot gyalogos sétaútvonalak hálózzák be. Számot tarthat még a látogatók érdeklődésére a futópálya, a gyógyfürdő, valamint a medencék. A sziget nyáron pop-up bárokkal és éttermekkel, valamint élő zenével telik meg.",
            R.drawable.margit, 3, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(13, "Túra a Zajnát-hegyekbe","A Zajnát-hegyek egy igen változatos felszínű hegycsoport a Pilis hegység déli részén, közvetlenül a Budai-hegység határán, Pilisvörösvár, illetve Piliscsaba területén. Nevezik Kopárosnak is, a területen 1927-ben megkezdett, és a táj képét azóta is meghatározó kopárfásítás nyomán.",
            R.drawable.zajnat, 3, "", ""))
        database.UserItemDao().insertActivity(ActivityItem(14, "Piknik a Kopaszi-gáton","A Kopaszi-gát az Összekötő vasúti híd (népnyelven sokszor még: Déli összekötő vasúti híd) lábánál, attól délre, Budapesten a XI. kerületben található. Mintegy 900 méter hosszan a Dunába nyúló gát, amely a Lágymányosi-öblöt választja el a Dunától. A gát területén több kisebb étterem és játszóház is működik, népszerű pihenő- és találkozóhely.",
            R.drawable.kopaszi, 3, "", ""))
    }
    ItemManager.users = database.UserItemDao().getAllUsers()
    }


        binding.btnLogin.setOnClickListener {
            when {
                binding.etEmailAddress.text.toString().isEmpty() -> {
                    binding.etEmailAddress.requestFocus()
                    binding.etEmailAddress.error = "Töltsd ki az e-mail címed!"
                }

                binding.etPassword.text.toString().isEmpty() -> {
                    binding.etPassword.requestFocus()
                    binding.etPassword.error = "Töltsd ki a jelszavad!"
                }
                else -> {
                    var jo=2
                    for(i in ItemManager.users){if((i.email==binding.etEmailAddress.text.toString()) &&
                        (i.password==binding.etPassword.text.toString())){

                        jo=1
                        ItemManager.User=i
                        startActivity(Intent(this, ChooseActivity::class.java))
                    }
                }
                if(jo==2) Toast.makeText(this,"Helytelen e-mail cím vagy jelszó!", Toast.LENGTH_LONG).show()

                }
            }
        }
    }

}