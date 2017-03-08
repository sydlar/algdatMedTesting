Test-orienterte oppgaver i Algoritmer og datastrukturer
==========================================================

Grunnidé
------------------------------

Oppgaver for studentene består av

- Oppgavetekst: Hva skal implementeres, under hvilke føringer?
- Et grenesnitt som skal implementeres, presentert som et `interface`
- Skjelettkode for én eller flere implementasjoner av grensesnittene, d.v.s. i form av kompilerbar java-kode.
- JUnit-tester (JUnit4). Disse skal helst feile i utgangspunktet.


Nytte
------------------

### Antallet tester som passerer
Antall tester man klarer er et fint mål på progresjon, og kan betraktes som en umiddelbar tilbakemelding.

### Deksningsgrad
Dekningsgraden kan være av stor interesse:

- Kodelinjer som ikke er dekket av testene *kan* tenkes å være unødvendige. Dette kan brukes til å forbedre/forenkle implementasjonene.
- Lav dekning kan brukes som en indikasjon på at man bør skrive flere tester

### Forsøk på å lure testene (*Fault injection*)

Ekstraoppgave for studentene:

- Lag en implementajon som klarer alle testene men som likevel inneholder bugs.
- Skriv en test som fanger opp denne bugen.

Dersom faglærer klarer å lage bevisst ukomplette tester, så legger man godt til rette for at studentene kan utforske dette videre på denne måten.