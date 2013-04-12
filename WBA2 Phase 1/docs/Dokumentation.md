# Web-basierte Anwendungen 2 - Verteilte Systeme

## Dokumentation zur Phase 1
Autor: Dominik Schilling

## Inhaltsverzeichnis

* [Aufgabe 1](#aufgabe-1)
* [Aufgabe 2](#aufgabe-2)
* [Aufgabe 3](#aufgabe-3)
* [Aufgabe 4](#aufgabe-4)
* [Aufgabe 5](#aufgabe-5)

## Aufgabe 1

_Erklären Sie kurz die Begriffe Wohlgeformtheit, Validität und Namespaces im Bezug auf XML und XML-Schema._

### Wohlgeformtheit
Ein XML-Dokument gilt als wohlgeformt, wenn es bestimmte Regeln bezüglich der Syntax eingehalten hat:

* **XML-Deklaration**  
  Ein typisches XML-Dokument beginnt mit der Angabe über die verwendete XML-Version und/oder Zeichenkodierung. Beispiel:  
  `<?xml version="1.0" encoding="UTF-8"?>`

* **Wurzelelement**  
  Das XML-Dokument muss ein Wurzelement Element besitzen, welches die folgenden Elemente umschließt.   
  ```xml
<wurzelelement>
		<kind>
		</kind>
</wurzelelement>
  ```

* **Tags schließen**   
  Ein Element kann entweder aus einem öffnen und schließenden Tag oder ein selbstschließenden Tag bestehen. Jedes öffnende Tag muss also auch wieder geschlossen werden.
  
* **Verschachtelung**  
  Elemente bzw. Tags können miteinander verschachtet werden. Eine über-Kreuz-Verschachtelung ist jedoch nicht erlaubt. Beispiel:  
  Falsch: `<elementOne><elementTwo></elementOne></elementTwo>`  
  Richtig: `<elementOne><elementTwo></elementTwo></elementOne>`
  
* **Elementnamen sind „case-sensitive”**  
  Die Groß- und Kleinschreibung von Elementnamen spielt eine Rolle. Ist der öffnende Tag zum Beispiel groß geschrieben, das schließende Tag hingegen klein, so gehören die Tags nicht dem selben Element an. Beispiel  
  `<element></ELEMENT>`
  
* **Unique Attributnamen pro Element**  
  In einem Element dürfen keine Attribute mit dem selben Namen vorkommen. Beispiel:  
  Falsch: `<element attribut="wert" attribut="wert"/>`
  Richtig: `<element attribut="wert" attribut2="wert"/>`  
  

### Validität
Ein XML-Dokument gilt als valide, wenn es die oben erwähnte Eigenschaft besitzt, also wohlgeformt ist. Gleichzeitig muss es aber auch zusätzlichen Regeln einhalten, sofern sie durch eine *Data Type Definition* (DTD) oder ein *XML-Schema* (XSD) definiert wurden.
Beide Typen definieren eine Grammatik, die das XML-Dokument erfüllen muss.

Beispiel für DTD:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE  [
  <!ELEMENT gruss (#PCDATA)>
]>
<gruss>Hallo Welt!</gruss>
```

Beispiel für XSD:
```xsd
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
	<xs:element name="recipes">
		<xs:complexType>
			<xs:sequence>
				<xs:element ref="recipe" minOccurs="1" maxOccurs="unbounded"/>
			</xs:sequence>
		</xs:complexType>
	</xs:element>
</xs:schema>
```

### Namespaces
Namespaces kommen zum Einsatz, um Elemente mit gleichen Namen zu differenzieren.
Beispiel einer Namespace Deklaration:  
`<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">`

Im XML-Dokument können die eigentlichen Namen mit dem Präfix `xs` ergänzt werden um so die Eindeutigkeit zu gewährleisten.

<a href="#inhaltsverzeichnis">zur Übersicht ⇑</a>

## Aufgabe 2

_**a)** Erzeugen Sie ein XML-Dokument, dass die Daten des folgenden Formulars vollständig erfasst: http://www.gm.fh-koeln.de/~vsch/anmeldung/gruppenanmeldung.html  
Füllen Sie das Dokument mit einem Beispieldatensatz. Achten Sie darauf, dass über das Formular mehrere Personen gleichzeitig erfasst werden können._

Source:

* [`/misc/Aufgabe 2/2a-registration.xml`](https://github.com/ocean90/wba2-ss2013/blob/master/WBA2%20Phase%201/misc/Aufgabe%202/2a-registration.xml)
* [`/misc/Aufgabe 2/2a-registration-demo.xml`](https://github.com/ocean90/wba2-ss2013/blob/master/WBA2%20Phase%201/misc/Aufgabe%202/2a-registration.xml)

_**b)** Erzeugen Sie ein JSON-Dokument, dass zu ihrem XML-Dokument äquivalent ist._

Source:

* [`/misc/Aufgabe 2/2a-registration.json`](https://github.com/ocean90/wba2-ss2013/blob/master/WBA2%20Phase%201/misc/Aufgabe%202/2a-registration.json)
* [`/misc/Aufgabe 2/2a-registration-demo.json`](https://github.com/ocean90/wba2-ss2013/blob/master/WBA2%20Phase%201/misc/Aufgabe%202/2a-registration.json)

<a href="#inhaltsverzeichnis">zur Übersicht ⇑</a>

### Aufgabe 3

_**a)** Gegeben ist folgendes Rezept: http://www.chefkoch.de/rezepte/24641006006067/Lenchen-s-Schokoladenkuchen.html  
Entwickeln Sie ein XML-Dokument, in dem die Daten des Rezeptes abgebildet werden. Achten Sie darauf, dass das Dokument semantisch möglichst reichhaltig ist._

Source:

* [`/misc/Aufgabe 3/3a-recipe.xml`](https://github.com/ocean90/wba2-ss2013/blob/master/WBA2%20Phase%201/misc/Aufgabe%203/3a-recipe.xml)
* [`/misc/Aufgabe 3/3a-recipe-demo.xml`](https://github.com/ocean90/wba2-ss2013/blob/master/WBA2%20Phase%201/misc/Aufgabe%203/3a-recipe-demo.xml)

----

_**b)** Betrachten Sie nun andere Rezepte auf der Webseite http://www.chefkoch.de. Beschreiben Sie welche Gemeinsamkeiten die Rezepte hinsichtlich ihrer Daten haben und worin Sie sich unterscheiden._

Gemeinsamkeiten:

* Einen Titel für das Rezept
* Eindeutige ID (durch URL gekennzeichnet)
* Eine Kategorie
* Eine Zutatenliste
* Eine Beschreibung zur Zubereitung
* Angabe zu Schwierigkeitsgrad, Brennwert und Arbeitszeit

Unterschiede:

* Vorkommen von Fotos
* Vorkommen von Kommentaren
* Vorkommen eines Untertitels
* Angaben zu Zutaten: Unterschiedliche Menge, Einheit, Name, Gruppierung
* Mögliche Angabe zu Koch-/Backzeit sowie Ruhezeit 

----

_**c)** Arbeiten Sie die Kriterien heraus, die für die Entwicklung einer XML-Schema-Datei beachtet werden müssen. Die Schema-Datei soll die Struktur für eine XML-Datei definieren, in der mehrere unterschiedliche Rezepte gespeichert werden können._

_+ Welche Daten müssen in simple und welche in complex-types abgebildet werden?  
+ Für welche Daten ist die Abbildung in Attributen sinnvoller?  
+ Welche Datentypen müssen für die Elemente definiert werden?  
+ Welche Restriktionen müssen definiert werden?_

**Was sind überhaupt Simple- bzw. Complex-Types?**  
Simple-Types sind einfach Elemente, die nur reinen Text ohne Kindelemente beinhalten. Dazu zählen auch Attribute. Complex-Types hingegen sind in ihrem Aufbau komplexer und können aus mehreren Attributen, Elementen und Sequenzen bestehen.

**Element oder Attribut?**  
Wie aus der vorherigen Definition zu entnehmen ist, sind komplexe Elemente nicht in Attributen darstellbar. Attribute eigenen sich daher für Werte die nur aus Zahlen bestehen, zum Beispiel IDs, oder aufgrund von Restriktionen schon vor definiert sind. Gleichzeitig muss man beachten, dass die XML Parser normalerweise Leerzeichen beachten. Dies ist bei den Attributen nicht der Fall. Komplexe Texte sollten somit auch nicht in Attributen widergespiegelt werden.

**Datentypen**  
Eine Übersicht der eingebauten Datentypen ist der XML Spezifikation zu entnehmen.  
http://www.w3.org/TR/xmlschema-2/#built-in-datatypes (aufgerufen am 11.04.2013)


Mit dieser Erkenntnis können nun folgende Annahmen bezüglich des Rezeptes gemacht werden:

* Attribut: **id**: Simple-Type, Type: Integer
* Attribut: **parentId**: Simple-Type, Type: Integer, optional
* Attribut: **amount**: Simple-Type, optional, Type: Float, Integer
* Attribut: **unit**: Simple-Type, optional, Type: String
  * Enumeration (TL, EL, Prise, ... ), Standard: ""
* Attribut: **width**: Simple-Type, Type: Integer, Required
* Attribut: **height**: Simple-Type, Type: Integer, Required
* Element: **recipes**: Complex-Type (Wurzelelement)
* Element: **recipe**: Complex-Type, 
* Element: **title**: Simple-Type, Type: String
* Element: **subtitle**: Simple-Type, Type: String
* Element: **category**: Complex-Type
* Element: **images**: Complex-Type, optional
* Element: **direction**: Complex-Type
* Element: **comments**: Complex-Type, optional
* Element: **comment**: Complex-Type, Unbegrenzt
* Element: **name**: Simple-Type, Type: String
* Element: **image**: Complex-Type, optional
* Element: **ingredients**: Complex-Type
* Element: **ingredient**: Complex-Type, Unbegrenzt
* Element: **times**: Complex-Type
* Element: **severity**: Complex-Type, Type: String
  * Enumeration( simple, normal, pfiffig )
* Element: **pre**: Simple-Type, Type: Integer, optional
* Element: **cook**: Simple-Type, Type: Integer, optional
* Element: **rest**: Simple-Type, Type: Integer, optional
* Element: **steps**: Complex-Type
* Element: **step**: Simple-Type, Type: String, Unbegrenzt
* Element: **date**: Simple-Type, Type: dateTime
* Element: **isHelpful**: Simple-Type, Type: boolean
* Element: **content**: Simple-Type, Type: String
* Element: **replies**: Complex-Type, optional
* Element: **userLevel**: Simple-Type, Type: Integer
* Element: **avatar**: Complex-Type, optional
* Element: **author**: Simple-Type, Type: String
* Element: **source**: Simple-Type, Type: xs:anyURI

----

_**d)** Erstellen Sie nun ein XML-Schema auf Basis ihrer zuvor definierten Kriterien. Generieren Sie nun auf Basis des Schemas eine XML-Datei und füllen Sie diese mit zwei unterschiedlichen und validen Datensätzen._

Source:

* [`/misc/Aufgabe 3/3d-recipes.xml`](https://github.com/ocean90/wba2-ss2013/blob/master/WBA2%20Phase%201/misc/Aufgabe%203/3d-recipes.xml)
* [`/misc/Aufgabe 3/3d-recipes.xsd`](https://github.com/ocean90/wba2-ss2013/blob/master/WBA2%20Phase%201/misc/Aufgabe%203/3d-recipes.xsd)

<a href="#inhaltsverzeichnis">zur Übersicht ⇑</a>

## Aufgabe 4
_In dieser Aufgabe entwickeln Sie mit Hilfe des JAXB Frameworks ein Java-Programm, welches die XML-Datei aus der vorigen Aufgabe einlesen, modifizieren und ausgeben kann._

Source:

* [`/src`](https://github.com/ocean90/wba2-ss2013/tree/master/WBA2%20Phase%201/src)

<a href="#inhaltsverzeichnis">zur Übersicht ⇑</a>

## Aufgabe 5
_Diskutieren Sie, warum es sinnvoll ist Daten in Formaten wie XML oder JSON zu speichern. Stellen Sie außerdem die beiden Formate gegenüber und erläutern Sie kurz deren Vor- und Nachteile._

Die Formate XML und JSON eigenen sich beide prinzipell für die Speicherung von Daten. Beide haben den Vorteil, Daten nach vorher definierten Regeln zu strukturieren, sodass sie auch von Maschinen gelesen werden können. Da es sich um Textdokumente handelt, sind sie allerdings auch für den Menschen lesbar.

XML hat den Vorteil, dass ein XML-Dokument mit eigenen Regeln erstellt werden kann, sei es durch DTD oder ein XML-Schema. Dieser Vorteil kann allerdings auch schnell zum Nachteil werden, wenn es darum geht, Daten von A nach B zu transportieren, da neben de eigentlichen Information noch die Tags und ggf. Attribute vorhanden sind.

Diesen Overhead gibt es bei einem JSON-Dokument nicht. Ein JSON-Dokument ist nichts anderes als ein JavaScript Object, welches mit dem [eval()](https://developer.mozilla.org/en-US/docs/JavaScript/Reference/Global_Objects/eval) (aufgerufen am 11.04.2013) Befehl ausgeführt wird. Aus diesem Grund stehen als Datentypen nur String, Boolean, Integer, Null, Array und das Objekt zur Verfügung.

Je nach Einsatzbereich sollte also das richtige Format gewählt werden:

 * XML als **Auszeichnungssprache**
 * JSON zum **Datenaustausch**
 
<a href="#inhaltsverzeichnis">zur Übersicht ⇑</a>