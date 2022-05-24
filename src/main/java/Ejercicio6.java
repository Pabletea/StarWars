public class Ejercicio6 {

    public Planets planets;

    public Ejercicio6() {
        planets = new Planets(ObtenerPlanetsRequest.Companion.get().getResults());


    }

    public void iniciarEjercicio6(){
        System.out.println("Iniciando el ejercicio 6");
        System.out.println("Obtener planetas por poblacion");
        int res= obtenerMasPobladosQue(6000000).length;
        System.out.println(res);
        System.out.println("Planetas que coinciden con terreno");
        Planet[] res2=obtenerPlanetasConTerreno("mountains");
        for(int i=0;i<obtenerPlanetasConTerreno("mountains").length;i++){
            System.out.println(res2[i]);
        }


    }


    public Planet[] obtenerMasPobladosQue(long poblacion){
        Planet[] out = planets.obtenerTodos();
        int i=0;
        for(Planet p:out){
            if(!p.getPopulation().contains("unknown")) {
                if (Long.parseLong(p.getPopulation()) > poblacion) {
                    out[i] = p;
                    i++;
                }
            }
            }
        Planet[] out2 = new Planet[i];

        System.arraycopy(out,0,out2,0,i);

        return out2;
    }

    public Planet[] obtenerPlanetasConTerreno(String terreno){
        Planet[] out = planets.obtenerTodos();
        int i=0;
        for(Planet p:out){
            if(p.getTerrain().equalsIgnoreCase(terreno)){
                out[i]=p;
                i++;
            }

        }
        Planet[] out2 =new Planet[i];
        System.arraycopy(out,0,out2,0,i);

        return out2;
    }

}
