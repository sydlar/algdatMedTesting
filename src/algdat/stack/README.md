Oppgave: Implementere en stakk
===================================

Del 1: Tabell-implementasjon
-------------------------------

Skriv ferdig `ArrayStack.java`, og sørg for at alle testene passerer.

I denne implementasjonen skal det brukes en tabell som underliggende datastruktur.

Del 2: Lenket implementajon
------------------------------

Skriv ferdig `LinkedStack.java`, og sørg for at alle testene passerer.

Som navnet antyder, skal denne stakken implementeres som en lenket liste.

Merknader
-----------------
Grensesnittet `Stack.java` inneholder `default`-metodene `peek`, `isEmpty` og `iterator`. Det forenkler oppgaven betraktelig. Men, noen disse `default`-metodene er dessverre ikke særlig effektive, og bør implementeres på nytt.


Her må du forholde deg til dokumentajsonen i grensesnittet `Stack.java`, samt testene definert i `ArrayStackTest.java` og `LinkedStackTest.java`.

Her er testene organisert i et klassehierarki som speiler hierarkiet mellom grensesnitt og implementasjoner. En alternativ fremgangsmåte er å bruke en parametrisert test som den vi ser i `algdat.bag.BagTest`.

