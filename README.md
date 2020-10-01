<h1> Medical Clinic Project </h1>

Projekt przychodni medycznej. Jest utrzymany w formie strony 
internetowej, na którą można się zalogować, umówić wizytę albo 
zmienić swoje dane.

Projekt ma osobną strukturę dla backendu i frontendu.
Link do frontendu: https://github.com/krzysztofplociennik/medical-clinic-frontend

**Stack**

Przy projekcie korzystałem z:
- java 8
- hibernate
- mysql
- spring boot
- spring security
- vaadin

**Instrukcja**

Na chwilę obecną jest 3 użytkowników z następującymi danymi = login | hasło: 
1. jamilyn | jaha
2. mariof | mafe
3. ryahn | ryhi

Dodatkowo można też zalogować się jako admin: 
admin | 123

**Jak wygląda strona?**

Widok loginu:

![login](https://i.imgur.com/XTP1Q5F.png)

Dash użytkownika: 

![dash](https://i.imgur.com/fBvBddp.png)

Strona rezerwowania wizyt:

![reserving1](https://i.imgur.com/CMoKSBb.png)

Można też konkretne wizyty usunąć z bazy, zaznaczając konkretny 
rekord:

![reserving2](https://i.imgur.com/vnc7z37.png)

Strona dostępnych lekarzy (dodatkowo można sprawdzić, jak zostali 
ocenieni oraz sami możemy ocenić ich):

![doctors](https://i.imgur.com/2MhHQYu.png)

Na samym końcu mamy możliwość podejrzenia danych zalogowanego
użytkownika oraz ich edycji (oprócz loginu):

![settings](https://i.imgur.com/T2sQC82.png)

Logując się jako admin mamy dodatkowo dostęp do jeszcze jednej 
zakładki na stronie: 

![admin](https://i.imgur.com/gsMYZlC.png)

Można w niej zobaczyć listę pacjentów, lekarzy, rezerwacji oraz ocen.
Przy wybraniu konkretnego obiektu pokazują się jego dane:

![admin-delete](https://i.imgur.com/le9Udgg.png)

oraz możliwość usunięcia z bazy danego obiektu (co też poprzedzone jest
wymaganym potwierdzeniem):

![admin-prompt](https://i.imgur.com/NrymPJa.png)

**Deploy**

W trakcie...
