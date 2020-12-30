# Application Rick and Morty and Co V2
créé par Wassil Khetim

## Présentation

**Rick and Morty and Co V2**, application developpée dans le cadre du projet android de 4ème année, est une amélioration de l'application developpée en 3ème année utilisant cette fois ci Kotlin.

Dans cette application on pourra retrouver en plus des données obtenues à partir de l'API *The Rick and Morty API* créée par Axel Fuhrmann et Talita et obtenable [ici](https://rickandmortyapi.com/),
un système d'authentification et de création de compte.

## Éléments de la consigne

Voici les éléments qui ont été respectés et ajoutés :

#### Éléments obligatoires (7/7):

- Design;
- Écran avec une liste d'éléments;
- Appel WebService à une API Rest;
- MVVM;
- Clean Architecture;
- Mise en place d'une base de données avec Room
- Language Kotlin;

#### Éléments bonus :

- Utilisation de GLIDE pour afficher les images;
- Gitflow;

## Fonctionalités

#### Écran d'accueil :

Lorsque l'on lance l'application, on arrive sur une page de connexion contenant deux champs de texte editables( login et password) ainsi que deux boutons( login et create account).
Pour le connexion, si les identifiants sont incorrectes cela affiche une erreur.

<p float="left">
  <img src=https://github.com/Wassangota/Android3A/blob/master/Screenshots/Screenshot_1590081995.png width=25%>
  <img src=https://github.com/Wassangota/Android3A/blob/master/Screenshots/Screenshot_1590082067.png width=25%>
</p>

#### Écran d'inscription

En arrivant sur cet écran on voit 3 champs éditables ( login, password et confirm password ) et le bouton pour valider l'inscription.
Si le login est déjà utilisé, cela affiche une erreur.

<p float="left">
  <img src=https://github.com/Wassangota/Android3A/blob/master/Screenshots/Screenshot_1590081995.png width=25%>
  <img src=https://github.com/Wassangota/Android3A/blob/master/Screenshots/Screenshot_1590082067.png width=25%>
</p>

#### Écran après connexion

Lorsque l'on lance l'application pour la première fois elle va effectuer un appel serveur vers l'api Rick et Morty et récupérer les informations nécessaires des personnages de la série et les stocké les données dans la base de données. En lançant l'application, si cette dernière trouve des données déjà sauvegardées, elle va les charger et les afficher à la place d'effectuer la demande get à l'API.

<p float="left">
  <img src=https://github.com/Wassangota/Android3A/blob/master/Screenshots/Screenshot_1590081995.png width=25%>
  <img src=https://github.com/Wassangota/Android3A/blob/master/Screenshots/Screenshot_1590082067.png width=25%>
</p>

#### Écran détail du personnage :

Lorsque l'on clique sur le nom de l'un des personnages dans la liste, l'application ouvre une nouvelle fenêtre (activity) donnant diverses détails du personnages.

<p float="left">
  <img src=https://github.com/Wassangota/Android3A/blob/master/Screenshots/Screenshot_1590082126.png width=25%>
  <img src=https://github.com/Wassangota/Android3A/blob/master/Screenshots/Screenshot_1590082151.png width=25%>
  <img src=https://github.com/Wassangota/Android3A/blob/master/Screenshots/Screenshot_1590082160.png width=25%>
</p>

On peut notamment voir la différence au niveau du bouton retour grace au design (blanc ancienne version).
