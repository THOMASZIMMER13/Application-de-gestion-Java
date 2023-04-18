public class employe {

protected String nom;
protected String prenom;
protected int age;
protected String dateEntre;
//final afin de créer une constante car la prim est fixé;
final double prim=300.0;

public employe (String sonNom, String sonPrenom, int sonAge, String saDateEntre) {
nom=sonNom;
prenom=sonPrenom;
age=sonAge;
dateEntre=saDateEntre;
} 

public double salaire () {
return prim; 
}

public String toString () {
return "nom "+nom+" mon prenom "+prenom+" age du salaries "+age+" date d'entre dans l'entreprise "+dateEntre;
}

}