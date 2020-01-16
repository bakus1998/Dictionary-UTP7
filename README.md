# UTP7

Stworzyć i przetestować (w metodzie main(...)) klasę Dictionary reprezentującą proste słowniki pojęć oraz umożliwiającą szybkie wykonanie operacji na nich. Dane do słownika są pobrane z pliku tekstowego, w którym każdy poprawny wiersz jest postaci:

hasło = definicja

przy czym jedno hasło może mieć kilka różnych definicji.

Nazwa pliku jest obowiązkowa: dictionary.txt, należy samodzielnie utworzyć plik i umieścić go w katalogu {user.home}.Niespełnienie tego warunku skutkuje brakiem punktów.



Klasa Dictionary powinna posiadać między innymi konstruktor oraz metody podane poniżej:

a. konstruktor - tworzy słownik czytając plik wejściowy, zawierający hasła z definicjami. Niepoprawne składniowo wiersze pliku wejściowego są ignorowane podczas czytania.

b. lookup - dla danego hasła zwraca kolekcję dostępnych, ponumerowanych (od 1) definicji. Kolekcja ta jest posortowana według porządku leksykograficznego definicji. Przykład wywołania: lookup("java").

c. add - dodaje do słownika hasło z definicją (o ile nie było ich wcześniej w słowniku). Przykład wywołania: add("java", "programming language").

d. delete - usuwa ze słownika podane hasło z definicją, wskazaną przez numer porządkowy (patrz. punkt b.). Przykład wywołania: delete("java", 2);

e. update - aktualizuje słownik, zamieniając dla podanego hasła podaną starą definicję na nową, podaną definicję. Przykład wywołania: update("java", "programming language", "coffee").

f. save - zapisuje aktualny stan słownika do pliku wyjściowego/wejściowego.



W rozwiązaniu zadania, oprócz poprawności dzialania programu, należy zwrócić szczególną uwagę na użycie odpowiednich typów kolekcji (listy, mapy, zbiory, ...) oraz na obsługę błędów. Niewykonanie testów skutkuje brakiem punktów.
