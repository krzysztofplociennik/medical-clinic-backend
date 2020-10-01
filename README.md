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

![login](src/main/resources/screenshots/login.png)

Dash użytkownika: 

![login](src/main/resources/screenshots/user%20-%20dashboard.png)

Strona rezerwowania wizyt:

![login](src/main/resources/screenshots/user%20-%20appointments1.png)

Można też konkretne wizyty usunąć z bazy, zaznaczając konkretny 
rekord:

![login](src/main/resources/screenshots/user%20-%20appointments2.png)

Strona dostępnych lekarzy (dodatkowo można sprawdzić, jak zostali 
ocenieni oraz sami możemy ocenić ich):

![login](src/main/resources/screenshots/user%20-%20doctors.png)

Na samym końcu mamy możliwość podejrzenia danych zalogowanego
użytkownika oraz ich edycji (oprócz loginu):

![login](src/main/resources/screenshots/user%20-%20settings.png)

Logując się jako admin mamy dodatkowo dostęp do jeszcze jednej 
zakładki na stronie: 

![login](src/main/resources/screenshots/admin%20-%20dashboard.png)

Można w niej zobaczyć listę pacjentów, lekarzy, rezerwacji oraz ocen.
Przy wybraniu konkretnego obiektu pokazują się jego dane:

![login](src/main/resources/screenshots/admin%20-%20settings.png)

oraz możliwość usunięcia z bazy danego obiektu (co też poprzedzone jest
wymaganym potwierdzeniem):

![login](src/main/resources/screenshots/admin%20-%20prompt.png)

**Deploy**

W trakcie...
