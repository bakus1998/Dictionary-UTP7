package zad1;

import java.io.*;
import java.util.*;

public class Dictionary {
    String path;
    HashMap<String, TreeSet<String>> mapa;
    List<String> values;

    public Dictionary(String path){
        this.path=path;
        add();
    }

    public void add(){
        mapa = new HashMap<>();
        String[] readWord;

        try {
            FileInputStream fis = new FileInputStream(new File(path));
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String s_reader;
            while ((s_reader = reader.readLine())!=null){
                readWord = s_reader.split(" = ");
                if(readWord.length==2) {
                    if(!mapa.containsKey(readWord[0])){
                        TreeSet set = new TreeSet();
                        set.add(readWord[1].toLowerCase());
                        mapa.put(readWord[0].toLowerCase(),set);
                    }else{
                        mapa.get(readWord[0].toLowerCase()).add(readWord[1]);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setArray(String key){
        key=key.toLowerCase();
        values = new ArrayList<>();
        for (String val : mapa.get(key)) {
            values.add(val);
        }
    }

    public void lookup(String key){
        key=key.toLowerCase();
        if(mapa.containsKey(key)) {
            int index_count = 1;
            for (String val : mapa.get(key)) {
                System.out.println(index_count++ + ". " + key + " = " + val);
            }
        }else{
            System.out.println("Brak '" + key + "' w słowniku!");
        }

    }

    public void add(String key, String vals){
        key=key.toLowerCase();
        vals=vals.toLowerCase();
        if(mapa.containsKey(key)){
            mapa.get(key).add(vals);
        }else{
            TreeSet set = new TreeSet();
            set.add(vals);
            mapa.put(key, set);
        }
    }

    public void delete(String key, int val){
        key=key.toLowerCase();
        setArray(key);
        if(mapa.containsKey(key)&&val<=values.size()) {
            mapa.get(key).remove(values.get(val-1));
            if( mapa.get(key).isEmpty()){
                mapa.remove(key);
            }
        }else{
            System.out.println("Brak podanego klucza lub podano złą wartość!");
        }
    }

    public void update(String key, String oldVal, String newVal){
        key=key.toLowerCase();
        oldVal=oldVal.toLowerCase();
        newVal=newVal.toLowerCase();
        if(mapa.containsKey(key)) {
            if(mapa.get(key).contains(oldVal)){
                mapa.get(key).remove(oldVal);
                mapa.get(key).add(newVal);
            }else{
                System.out.println("Brak takiej definicji!");
            }
        }else{
            System.out.println("Brak podanego klucza!");
        }
    }

    public void save(){
        StringBuilder toSave = new StringBuilder();
        Iterator<Map.Entry<String, TreeSet<String>>>
                iterator = mapa.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, TreeSet<String>> entry = iterator.next();
            for (String val : mapa.get(entry.getKey())) {
                toSave.append(entry.getKey()+ " = " + val + "\n");
            }
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
            bw.write(toSave.toString());
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
