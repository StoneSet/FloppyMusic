# FloppyMusic
Programme basé sur MoppyDesk mais en français
<pre>
    __  ___                        ___       __                                __
   /  |/  /___  ____  ____  __  __/   | ____/ /   ______ _____  ________  ____/ /
  / /|_/ / __ \/ __ \/ __ \/ / / / /| |/ __  / | / / __ `/ __ \/ ___/ _ \/ __  / 
 / /  / / /_/ / /_/ / /_/ / /_/ / ___ / /_/ /| |/ / /_/ / / / / /__/  __/ /_/ /  
/_/  /_/\____/ .___/ .___/\__, /_/  |_\__,_/ |___/\__,_/_/ /_/\___/\___/\__,_/   
            /_/   /_/    /____/                                                   v2 </pre>
            
            
            
            
            
### **Traduction en français :**

Moppy est un programme de contrôleur de disquette conçu pour l'Arduino Uno.

Cette version tente d'améliorer le MoppyDesk original en ajoutant des fonctionnalités supplémentaires, y compris:

    * Support MIDI-IN
    * Contrôle de sortie par canal
    * Prise en charge de plusieurs périphériques Arduinos / MIDI
    * Drive pooling
    * Ce document est censé être une sorte de guide de démarrage rapide. Wiki : (Repo de MoppyAdvanced)
    * Le français

__Installation__

Le code Arduino requiert la bibliothèque TimerOne disponible ici: http://www.arduino.cc/playground/Code/Timer1

La dernière version utilise NRJavaSerial, qui devrait inclure des lecteurs natifs appropriés pour la plupart des systèmes. Si vous avez précédemment exécuté une ancienne version de Moppy, vous devez vous assurer que les fichiers jar RXTX ne sont pas chargés (c'est-à-dire pas sur classpath, etc.), car les deux bibliothèques entrent en conflit si les deux présent.

Chargez le code Arduino fourni à l'Arduino de votre choix (nécessite l'IDE Arduino) et ouvrez le code Java inclus dans votre IDE préféré. Ce code comprend un projet NetBeans pour votre commodité, de sorte que vous devriez pouvoir ouvrir le projet directement dans NetBeans.

__Matériel__

J'ai codé Moppy en utilisant un Arduino Uno, mais cela devrait fonctionner très bien sur la plupart des Arduinos. Les broches sont reliées par paires aux lecteurs de disquettes comme suit: les broches individuelles (2,4,6 ...) sont connectées à la broche STEP de chaque lecteur, les broches binaires correspondantes (3,5,7 ...) sont connectées au La broche de commande DIRECTION de chaque lecteur. Donc, la première disquette serait connectée à la broche 2 et 3, la deuxième disquette à 4 et 5, et ainsi de suite.

Certaines informations de brochage peuvent être trouvées ici: http://pinouts.ru/Storage/InternalDisk_pinout.shtml

Assurez-vous de mettre à la terre la broche de sélection de lecteur correcte, ou le lecteur ne répondra à aucune entrée (connectez simplement la broche de sélection de lecteur sur la disquette à la broche directement en dessous). Vous pouvez indiquer quand vous avez sélectionné le bon lecteur, car la lumière à l'avant du variateur s'allume.

En outre, il est TRÈS IMPORTANT que votre Arduino soit mis à la terre avec les lecteurs, ou les lecteurs ne enregistrent pas les impulsions correctement. Pour ce faire, assurez-vous que la broche GND sur l'Arduino est connectée à la broche impaire située au-dessous de la broche STEP sur la disquette (c'est-à-dire si la broche STEP est 20, connectez la broche GND d'Audnio à la broche 19). Vous devrez peut-être le faire pour la broche DIRECTION (je l'ai fait pour les deux, mais je ne sais pas si c'est nécessaire).

__Configuration et utilisation__

Ouvrez le code dans NetBeans (ou votre IDE préféré) et exécutez-le. Vous pouvez également créer le fichier MoppyDesk.jar et l'exécuter directement.
Sur la moitié droite de l'écran, vérifiez les cases de sortie du canal pour le nombre de lecteurs que vous avez connecté, sélectionnez "Moppy" et choisissez le port COM auquel votre Arduino est connecté.
Cliquez sur le bouton "Charger la séquence" et sélectionnez un fichier MIDI approprié (voir ci-dessous).
Cliquez sur le bouton "Connecter" pour connecter le programme aux périphériques spécifiés dans la zone de sortie.
Cliquez sur "Démarrer" pour lancer la lecture (si tout va bien).
Le bouton Arrêter / Réinitialiser arrêtera la lecture et réinitialise les lecteurs.
Informations et directives sur les fichiers MIDI

Les fichiers MIDI doivent avoir un canal MIDI pour chaque broche de contrôleur sur l'Arduino. Le canal 1 sera envoyé à pin2, canal 2 à pin4, et c.
Chaque lecteur ne peut jouer qu'une seule note à la fois.
Le logiciel ne tentera que de jouer des notes entre C1 et B4. Les lecteurs de disquettes ne semblent pas répondre bien aux notes en dehors de cette plage (surtout supérieure).
Généralement, les notes plus courtes ont tendance à mieux ressentir, car des notes plus longues sont marquées par les directions de changement de tête de lecture à plusieurs reprises.
Croisez les doigts et profitez-en!

*======================================================================*
![alt text](https://stoneset.github.io/images/floppymusicprogramm.jpg "Screenshot du programme")
*======================================================================*
# **Autres :**

__License :__
Rien, respectez juste la license de MoppyDesk par contre... ;)

__Source__
heu, je cherches toujours...

__Copyright :__

StoneSet & Sammy

~-~

Repo officiel : https://github.com/SammyIAm/Moppy
