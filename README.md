# Zadanie kalkulator podrozy
Aplikacja obliczająca długość podróży

# Wygląd
<img src="https://github.com/sztoslol/Zadanie_kalkulator_podrozy/blob/main/img/Zrzut%20ekranu%202022-12-13%20o%2011.11.54.png" data-canonical-src="https://gyazo.com/eb5c5741b6a9a16c692170a41a49c858.png" width="230" height="400" /><br>

# Funkcjonalność
- Aplikacja pozwala na wybranie dwóch dat odjazdu oraz przyjazdu, na tej podstawie obliczana jest długość podróży
- Aby wybrać datę należy zaznaczyć ją kalenarzu a następnie kliknąć przycisk pod odpowiadającym tekstem
- Po wybraniu obu dat długość podróży obliczy się sama a następnie wyświetli ją

# Niezawodność
- Aplikacja po uruchomieniu automatycznie ustala zakres dat - Maksymalną, czyli do 2 lat w przyszłość i Milimalną, czyli dziś co blokuje możliwość podróżowania w przeszłość 
- Aplikacja składa się z jednego okna głownego
- Podczas zatrzymania działania aplikacja wstrzymuje swoją pracę
- Po wznowieniu funkcjonowania aplikacji na nowo ustalany jest przedział dat aby zapobiec sytuacją
- Aplikacja nie jest priorytetowa i nie wymaga dużej ilości pamięci
- 'Zabicie aplikacji' powoduje jej zamknięcie. Aplikacja nie zapisuje danych wybranych podróży trwale 

# Wybór środowiska
- Aplikacja została wykonana w Andorid Studio

# Cykl funkcjonowania
- onCreate - 
