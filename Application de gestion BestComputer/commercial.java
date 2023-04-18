public class commercial extends employe { 

int nbH =140;

public commercial (String sonNom, String sonPrenom, int sonAge, String saDateEntre) {
super(sonNom, sonPrenom, sonAge, saDateEntre); 
}

public double salaire () {
return nbH*5+300+super.salaire();
} 

public String toString () {
return "Intitulé du poste : commercial, "+nom+" "+prenom+" "+age+" ans Entré dans l'entreprise le: "+dateEntre+" salaire : "+salaire()+" euros"; }

}