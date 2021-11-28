package com.extendedclip.papi.expansion.compass;

import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.codemc.worldguardwrapper.WorldGuardWrapper;
import org.codemc.worldguardwrapper.region.IWrappedRegion;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class CompassExpansion extends PlaceholderExpansion implements Configurable {

    private String continents;
    private String compass;
    public static List<String> compassS;

    @Override
    public boolean canRegister() {
        if (Bukkit.getServer().getPluginManager().getPlugin("WorldGuard") == null) return false;
        worldguard = WorldGuardWrapper.getInstance();
        return worldguard != null;
    }

    @Override
    public Map<String, Object> getDefaults() {
        Map<String, Object> defaults = new HashMap<>();
        defaults.put("continents", ":Ocean,__global__:Ocean,europa:Europa,asia:Asia,africa:Africa,oceania:Oceania,americadenord:America De Nord,americadesud:America De Sud,antarctica:Antarctica");
        defaults.put("compass", "⼏,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,一");
        return defaults;
    }

    @Override
    public boolean register() {
        continents = getString("continents", ":Ocean,:__global__,europa:Europa,Asia:asia,Africa:africa,Oceania:oceania,America De Nord:americadenord,America De Sud:americadesud,Antarctica:antarctica");
        compass = getString("compass", "⼏,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,一");
        compassS = retrieveCompass(compass);
        return super.register();
    }

    @Override
    public @NotNull String getIdentifier() {
        return "compass";
    }

    @Override
    public @NotNull String getAuthor() {
        return "gush3l";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    private WorldGuardWrapper worldguard;

    private IWrappedRegion getRegion(Location location) {
        if (location == null) {
            return null;
        }
        try {
            Map<String, Integer> regions = worldguard.getRegions(location).stream().sorted(
                            Comparator.comparingInt(IWrappedRegion::getPriority).reversed())
                    .collect(toMap(IWrappedRegion::getId, IWrappedRegion::getPriority, (v1, v2) -> v2, LinkedHashMap::new));

            Optional<IWrappedRegion> region = worldguard.getRegion(location.getWorld(), regions.keySet().toArray(new String[0])[0]);
            return region.orElse(null);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String identifier) {

        if (player == null) {
            return "";
        }

        IWrappedRegion region = getRegion(((Player) player).getLocation());
        if (identifier.equals("get")){
            if (player.getPlayer() == null){
                return "";
            }
            double yaw = player.getPlayer().getLocation().getYaw();
            if (yaw < -180){
                yaw=yaw+360;
            }
            if (0<=yaw && yaw <=10){
                return compassS.get(0);
            }
            if (10<yaw && yaw <=20){
                return compassS.get(1);
            }
            if (20<yaw && yaw <=30){
                return compassS.get(2);
            }
            if (30<yaw && yaw <=50){
                return compassS.get(3);
            }
            if (50<yaw && yaw <=60){
                return compassS.get(4);
            }
            if (60<yaw && yaw <=70){
                return compassS.get(5);
            }
            if (70<yaw && yaw <=80){
                return compassS.get(6);
            }
            if (80<yaw && yaw <=90){
                return compassS.get(7);
            }
            if (90<yaw && yaw <=100){
                return compassS.get(8);
            }
            if (100<yaw && yaw <=110){
                return compassS.get(9);
            }
            if (110<yaw && yaw <=120){
                return compassS.get(10);
            }
            if (120<yaw && yaw <=130){
                return compassS.get(11);
            }
            if (130<yaw && yaw <=150){
                return compassS.get(12);
            }
            if (150<yaw && yaw <=160){
                return compassS.get(13);
            }
            if (160<yaw && yaw <=170){
                return compassS.get(14);
            }
            if (170<yaw && yaw<=180){
                return compassS.get(15);
            }
            if (yaw>=-180 && -170>=yaw){
                return compassS.get(16);
            }
            if (180<yaw && yaw<=190){
                return compassS.get(16);
            }
            if (yaw>=-170 && -160>=yaw){
                return compassS.get(17);
            }
            if (190<yaw && yaw<=200){
                return compassS.get(17);
            }
            if (yaw>=-160 && -150>=yaw){
                return compassS.get(18);
            }
            if (200<yaw && yaw<=210){
                return compassS.get(18);
            }
            if (yaw>=-150 && -140>=yaw){
                return compassS.get(19);
            }
            if (210<yaw && yaw<=220){
                return compassS.get(19);
            }
            if (yaw>=-140 && -130>=yaw){
                return compassS.get(20);
            }
            if (220<yaw && yaw<=230){
                return compassS.get(20);
            }
            if (yaw>=-130 && -110>=yaw){
                return compassS.get(21);
            }
            if (220<yaw && yaw<=250){
                return compassS.get(21);
            }
            if (yaw>=-110 && -100>=yaw){
                return compassS.get(22);
            }
            if (250<yaw && yaw<=260){
                return compassS.get(22);
            }
            if (yaw>=-100 && -90>=yaw){
                return compassS.get(23);
            }
            if (260<yaw && yaw<=270){
                return compassS.get(23);
            }
            if (yaw>=-90 && -80>=yaw){
                return compassS.get(24);
            }
            if (270<yaw && yaw<=280){
                return compassS.get(24);
            }
            if (yaw>=-80 && -70>=yaw){
                return compassS.get(25);
            }
            if (280<yaw && yaw<=290){
                return compassS.get(25);
            }
            if (yaw>=-70 && -60>=yaw){
                return compassS.get(26);
            }
            if (290<yaw && yaw<=300){
                return compassS.get(26);
            }
            if (yaw>=-60 && -50>=yaw){
                return compassS.get(27);
            }
            if (300<yaw && yaw<=310){
                return compassS.get(27);
            }
            if (yaw>=-50 && -40>=yaw){
                return compassS.get(28);
            }
            if (310<yaw && yaw<=320){
                return compassS.get(28);
            }
            if (yaw>=-40 && -30>=yaw){
                return compassS.get(29);
            }
            if (320<yaw && yaw<=330){
                return compassS.get(29);
            }
            if (yaw>=-30 && -20>=yaw){
                return compassS.get(30);
            }
            if (330<yaw && yaw<=340){
                return compassS.get(30);
            }
            if (yaw>=-20 && yaw<0){
                return compassS.get(0);
            }
            if (340<yaw && yaw<=360){
                return compassS.get(0);
            }
            return compassS.get(compassS.size()-1);
            
        }

        if (identifier.equals("direction")){

            if (player.getPlayer() == null) return "";

            double yaw = player.getPlayer().getLocation().getYaw();
            if (yaw < -180){
                yaw=yaw+360;
            }
            if (0<yaw && yaw<=31){
                return "S";
            }
            if (31<yaw && yaw<=59) {
                return "SW";
            }
            if (59<yaw && yaw<=121) {
                return "W";
            }
            if (121<yaw && yaw<=149) {
                return "NW";
            }
            if (149<yaw && yaw <=211) {
                return "N";
            }
            if (149<yaw && yaw<=179){
                return "N";
            }
            if (yaw>=-180 && yaw<-149){
                return "N";
            }
            if (211<yaw && yaw <=239) {
                return "NE";
            }
            if (yaw>=-149 && yaw<-121){
                return "NE";
            }
            if (239<yaw && yaw <= 301) {
                return "E";
            }
            if (yaw>=-121 && yaw<-59){
                return "E";
            }
            if (301<yaw && yaw <=329) {
                return "SE";
            }
            if (yaw>=-59 && yaw<-31){
                return "SE";
            }
            if (329<yaw && yaw<=359) {
                return "S";
            }
            if (yaw>=-31 && yaw<=0){
                return "S";
            }
            return "";
        }

        if (identifier.equals("yaw")){
            double yaw = player.getPlayer().getLocation().getYaw();
            return String.valueOf(yaw);
        }

        if (identifier.equals("continent")){
            String regionName;
            if (region == null) regionName = "__global__";
            else regionName = region.getId();
            HashMap<String,String> continentsList = retrieveContinents(continents);
            if (continentsList.containsKey(regionName)){
                return continentsList.get(regionName);
            }
        }
        return "";

    }

    private List<String> retrieveCompass(String compass) {
        String[] compassList = compass.split(",");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, compassList);
        return list;
    }

    private HashMap<String,String> retrieveContinents(String continents) {
        String[] continentsList = continents.split(",");
        HashMap<String,String> list = new HashMap<>();
        for (String s : continentsList){
            String[] sA = s.split(":");
            list.put(sA[0],sA[1]);
        }
        return list;
    }

}
