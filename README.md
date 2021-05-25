# Biblioteca 
## Lupu Andreea

Acest proiect este creat pentru cursul de Programare Avansata pe Obiecte. 

## Descrierea sistemului 
In cadrul sistemului au fost utilizate urmatoarele clase:

1. Biblioteca
2. Carte
3. Autor
4. Cititor
5. Sectiune
6. Eveniment
7. Imprumut
8. Personal

### Functionalitati

Lista celor 8 tipuri de clase selectionate este:
1. Biblioteca contine urmatoarele campuri: 
  * numele bibliotecii
  * o lista de persoane in care se stocheaza personalul bibliotecii
  * o lista de autori ale cartilor existente in biblioteca
  * o lista de cititori, membrii ai bibliotecii
  * o lista de evenimente organizate de catre biblioteca 
  * o lista de imprumuturi realizate de catre cititori
  * o lista de produse ce reprezinta posibilitatile de imprumut ale cititorilor

  De asemenea biblioteca implementeaza functii de set si get pentru toti membrii sai 
  
2. Clasa Carte retine numele si titlul cartii. Suprascrie functia de (**toString**) pentru a se putea realiza exportul continutului in fisier .csv
3. Clasa Cititor contine campurile:
  * nume cititor
  * o lista a cartilor impumutate
  Contine functii de set si get pentru informatii. Face overload pentru (**toString**) pentru a se putea realiza exportul continutului in fisier .csv
  
4. Classa AudoBuck este similara cu cea a Cartii
5. Clasa Produs contine 
  * titplul produsului 
  * tipul de produs selectionat care este un enum
  * o cantitate selectionata 
  * un reiting ales de catre cititor

6. Film contine sectiune, nume regizor si lungime.
7. Eveniment nummeEveniment si data evenimentlui 
8. Clasa autor contine numele autorului 

Pe langa aceste clase am mai implementat si urmatoarele clase:
1. BaseObject - creaza automat id-ul pentru fiecare obiect creat
              - este extins de absolut fiecare clasa din proiect

2. IOOperation -  
10. In clasa IOOperation se realizeaza exportul 
  * permite inregistrarea mai multor carti retunetu in ordine alfabetica
  * permite creerea unei liste de autori ale cartilor existente in biblioteca
  * are o lista de imprumuturi un cititorii pot adauga cartile pe care doresc sa le imprumute
  * retine evenimentele care sunt organizate in cadrul bibliotecii
