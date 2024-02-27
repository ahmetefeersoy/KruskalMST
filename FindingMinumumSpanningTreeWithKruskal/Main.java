import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
    Graph graphOfCity = readCityFile();
        KruskalMST kruskalMST = new KruskalMST(graphOfCity);
        System.out.println("Paths are:");
        for(Edge m : kruskalMST.edges()){
            System.out.println(m.either().getName()+"-"+ m.other(m.either()).getName()+": "+m.getDistance());
        }

        
    }
    


    private static Graph readCityFile() throws IOException{
        List<City> listOfCities = new ArrayList<City>();
        Scanner scn = new Scanner(System.in);
        String filename = scn.nextLine().trim();
        scn.close();
        String filepath = "/Users/ahmetefeersoy/Desktop/VSC/CMPE224HW3Q1/"+filename;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
    
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cityLoc = line.split(",");
                City city = new City(Integer.parseInt(cityLoc[1]), Integer.parseInt(cityLoc[2]), cityLoc[0]);
                listOfCities.add(city);
            } 
            
           Graph cityGraph = new Graph(listOfCities.size());

        for(int i=0;i<listOfCities.size();i++){
            for(int j=i+1;j<listOfCities.size();j++){
                Edge edge=null;
                edge =new Edge(listOfCities.get(i),listOfCities.get(j));
                cityGraph.addEdge(edge);
            }
        }
        return cityGraph;
        } catch (IOException e) {
            throw e;
        }
             

    }
    
        
    
}



