public class technicien extends employe { 

private int nbH =140;

public technicien (String sonNom, String sonPrenom, int sonAge, String saDateEntre) {
super(sonNom, sonPrenom, sonAge, saDateEntre); 
}


public double salaire () {
return nbH*5+400+super.salaire();
} 

public String toString () {
return "Intitulé du poste : technicien, "+nom+" "+prenom+" "+age+" ans Entré dans l'entreprise le: "+dateEntre+" salaire : "+salaire()+" euros"; }

}