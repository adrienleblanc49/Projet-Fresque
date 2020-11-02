package ProjectForm;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws Exception {

		System.out.println("\n-------- \n Création de formes \n--------\n");
		
		//Création de points :
		
		ArrayList<Point> points=new ArrayList<Point>();
		points.add(new Point(1,1));
		points.add(new Point(1,3));
		points.add(new Point(2,4));
		points.add(new Point(3,3));
		points.add(new Point(3,1));
		
		Point m1 = new Point(1,2);
		Point m2 = new Point(2,2);
		Point m3 = new Point(4,4);
		
		//Créations de formes
		//Polygone
		
		Polygone t=new Polygone(4,4,Couleur.NOIR, points);

		ArrayList<Point> trianglelist = new ArrayList<Point>();
		trianglelist.add(m1);
		trianglelist.add(m2);
		trianglelist.add(m3);
		Polygone poly1 = new Polygone(1, 1, Couleur.BLANC, trianglelist);
		
		// Ellipse
		Ellipse ellipse1 = new Ellipse(2,8, Couleur.ROSE, 2,4);
		
		// Cercle
		Cercle c1 = new Cercle(5,5);
		
		//Ligne
		Ligne l1 = new Ligne(0, 0, Couleur.BEIGE, m3, m2, 4);

		
		// Techniques
		Polygone p = t.translation(45, 10);
		Polygone poly2 = poly1.translation(4, 1);
		Cercle c2 = c1.homothetie(3);
		Ligne l2 = l1.rotation(90);
		
		// Impression console des formes
		System.out.println("poly1: " +poly1);
		System.out.println("poly2: " +poly2);
		System.out.println("t: " +t);
		System.out.println("p: " +p);
		System.out.println("ellipse1: " +ellipse1);
		System.out.println("cercle1: " +c1);
		System.out.println("cercle2: " +c2);
		System.out.println("ligne1: " +l1);
		System.out.println("ligne2: " +l2);
		
		
		
		// Mesures et autres méthodes des formes
		System.out.println("");
		System.out.println("(polygone t) " +t.perimetre());
		System.out.println("(polygone t) " + t.aire());
		System.out.println("nombre de sommets de t: " +t.getNbSommets());


		
		//Créations d'Images
		System.out.println("\n-------- \n Création d'Image \n--------\n");

		ArrayList<Forme> test1 = new ArrayList<>();
		test1.add(t);
		test1.add(t);
		test1.add(p);
		test1.add(p);
		test1.add(poly1);
		test1.add(poly2);

		ArrayList<Forme> test2 = new ArrayList<>();
		test2.add(c1);
		test2.add(c2);
		
		ArrayList<Forme> test3 = new ArrayList<>();
		test3.add(l1);
		test3.add(l2);
		
		Image image0 = new Image(test1);
		Image image2 = new Image(test2);
		Image image3 = new Image(test3);
		
		// Retrait des doublons d'une image
		Image image1 = image0.retirerDoublons(test1);
		
		//Affichage des images
		System.out.println(image1);
		System.out.println(image2);
		System.out.println(image3);
		
		//affichage d'argument localisé
		System.out.println("Forme localisée dans une Image:\n" + image1.getForme(2));
		
		//Création de Dessins
		System.out.println("\n-------- \n Création de Dessin \n--------\n");
		
		ArrayList<Image> arrayImages1 = new ArrayList<>();
		arrayImages1.add(image1);
		arrayImages1.add(image2);
		Dessin dessin1 = new Dessin(arrayImages1);
		System.out.println(dessin1);
		
		ArrayList<Image> arrayImages2 = new ArrayList<>();
		arrayImages2.add(image3);
		arrayImages2.add(image2);
		Dessin dessin2 = new Dessin(arrayImages2);
		System.out.println(dessin2);
		
		Dessin dessin_null = new Dessin(null);
		System.out.println(dessin_null);
		
		// affichage d'argument localisé
		System.out.println("Forme localisée dans une Image du Dessin:\n" +dessin1.getImage(1).getForme(0));

		System.out.println("\n-------- \n Création de Fresque \n--------\n");
		
		ArrayList<Dessin> arrayDessins = new ArrayList<>();
		arrayDessins.add(dessin1);
		arrayDessins.add(dessin2);
		arrayDessins.add(dessin_null);
		
		
		Fresque fresque1 = new Fresque(arrayDessins);
		System.out.println(fresque1);
		
		// affichage d'argument localisé
		System.out.println("Forme localisée dans une Image d'un Dessin de la Fresque:\n" +fresque1.getDessin(0).getImage(0).getForme(0));

	}

}
