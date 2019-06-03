import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.*;

public class Exercises {

    private static final String FIRST_NAMES = "Chris,Amanda,Aidan,John,Paul,Alice,Mark,Tim,Tania,Warren,Adrian,Tamara,Kelly,Bethanie,Lubna,David,Joe,Timothy,Vasileios,Neil,Phillip,Karl,Andrew,Sam,Catherine,Oscar,Jan,Helen,John,Sul,Sam,Peter,Peter,Maria,Mandeep,Harriet,Chris,Christos,Fraser,Guilherme,Nicola,Christopher,Aisling,Robert,Colm,Paul,Stephen,Jenni,Tito,James,Norman,Mark,Katrina,Dru,Alexander,Sarahh,Stephen,Edward,Michael,Stefano,Adam,Amy,Tristan,Neil,Agnes,Balkrishna,Sijy,Adrian,Stephen,Berkan,Mike,Marc,James,Vinjoy,Martin,Chris,John,Mark,Max,Neil,Danya,Aqib,Jeff,Jane,Mohsin,Jane,Hannah,Simon,Nicola,Chris,Bradley,Vibhu,Martyna,Darren,Ben,Stefano,Simon,Ian,Simon,Steve,John,Ben,Tracy,Benjamin,Vishnu,Shaun,Mark,Becky,Amir,Jenny,Philippa,Paul,Robert,David,Stuart,Phil,Holly,Enrico,Craig,Amir,Simon,Regan,Andrew,Gareth,Jim,Amber,Stephen,James,David,Byron,Dave,Angelos,Kesh,Emily,Alex,Keith,Sean,Muhammad,Tom,Christopher,Faiza,Ashley,David,Emma,Graham,Jason,Yasmin,Matthew,Andy,Dave,Thomas,David,Heather,Alan,Timothy,Seema,Matt,Edward,Ed,Davide,Mike,Damien,Bryan,Stuart,Johnny,Deepak,Ceri,Joshi,Aparna,Scott,Neil,Andy,Nick,Ryan,Marne,Damian,Dave,Russell,Jessica,Conor,Joseph,Craig,Mujtaba,Leon,Stafford,John,Alan,Danny,Mark,Paul,Jonathan,Phillip,Kishen,Nuno,Grant,SimonJ,Tom,Martin,John,Amit,Sam,James,Tim,Pawel,Paul,Oxidized,Chris,Kimberley,Adrian,Ahmad,Anthony,Andy,Ian,Mark,Chris,Antreas,Tom,Michael,Alec,Elly,Craig,Wesley,Jonathan,Charlie,Jack,Matt,JamesE,Daniel,SV,Chris,Karim,Ryan,Rowan,Romin,Jenna,Thomas,Elliot,Michael,Shaun,James,Dylan,Chris,Polly,Nick,Lee,David,Ben,Hannah,Lee,Emina,Jonathan,Darren,Victoria,Chris,Janis,Paul,Jemma,Thomas,Isaac,Darren,Barry,Sien,Raluca,David,Chloe,Lee,David,Andy,Katerina,Daniel,Darren,Lynsey,Adam,Erin,Dan,Peter,Lukasz,David,Jason,Georgia,Joseph,Michael,Ryan";
    private static final String FULL_NAMES = "Jenniffer Dail,Randee Dejohn,Diamond Schoonmaker,Mai Langstaff,Lucienne Markee,Johnette Lamirande,Jade Rojero,Zelma Tarin,Curtis Fimbres,Bronwyn Litten,Dan Jolley,Dante Blessing,Cinda Cade,Shawana Wengert,Leilani Senior,Alvin Wojtczak,Andres Sabat,Erline Feller,Tamesha Abshire,Barry Laurie,Claudette Pinedo,Temple Knipe,Ulrike Bolivar,Lady Eppler,Buena Tone,Ethel Grenz,Julene Lalor,Tatyana Escalona,Masako Franks,Edie Willeford,Catherina Corrado,Eugenie Trowbridge,Cortez Harps,Young Faris,Federico Como,Ellan Kugler,Lonny Spano,Lyla Sasser,Connie Sumpter,Camila Richie,Tennie Citizen,Theda Tillinghast,Dalton Farless,Ozella Averett,Bob Gallogly,Tania Cervantes,Gwenn Sevin,Eliana Pressman,Ivan Fluharty,Keila Kelemen";

    public static final Map<String, String> STAFF = new HashMap<>();

    public String oneGetFirstNames() {
        return FIRST_NAMES;
    }

    public String threeGetFirstNames() {
        return FIRST_NAMES;
    }

    public String fourGetFirstNames() {
        return FULL_NAMES;
    }

    public String fiveGetFullNames() {
        return FULL_NAMES;
    }

    public Map<String, String> sixGetNameAndJob() {
        STAFF.put("Bob Smith", "Reception");
        STAFF.put("Sarah Jones", "Finance");
        STAFF.put("James Franklin", "Finance");
        STAFF.put("Janice Warburton", "IT");
        STAFF.put("Mark Smith", "Recruitment");
        STAFF.put("Rita Wright", "IT");
        STAFF.put("Sue Griffiths", "Recruitment");
        return STAFF;
    }

    public List<String> getListOfNames(String names) {
        return Arrays.asList(names.split(","));
    }


    public Set<String> getCollectionOfNamesWithNoDuplicates(Collection<String> names) {
        return new HashSet<>(names);
    }


    public Map<String, Integer> getNumberOfEachName(Collection<String> listOfNames) {
        return listOfNames.stream()
                .collect(Collectors.toMap(name -> name, count -> 1, Integer::sum));
    }

    public Set<String> getUniqueFirstNamesFromFullNames(String fullNamesString) {
        return Arrays.stream(fullNamesString.split(","))
                .map(fullName -> fullName.split(" ")[0])
                .collect(Collectors.toSet());
    }

    public boolean checkIfOrdered(List<String> nameList) {
//        return nameList.stream()
//                .sorted()
//                .collect(Collectors.toList())
//                .equals(nameList);

//        for (int i = 0; i < nameList.size() - 1; i++) {
//            if(nameList.get(i).compareTo(nameList.get(i + 1)) > 0){
//                return false;
//            }
//        }
//        return true;

        String previous = null;
        for (String name:nameList) {
            if (previous != null && previous.compareTo(name) > 0) {
                return false;
            }
            previous = name;
        }
        return true;
    }

    public Map<String, String> swapKeyAndValue(Map<String, String> staffToDepartmentMap) {
        return staffToDepartmentMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (val1, val2) -> val1 + ", " + val2));

//        Map<String, String> reversedMap = new HashMap<>();
//        for (Map.Entry<String, String> entry : staffToDepartmentMap.entrySet()) {
//            if(reversedMap.containsKey(entry.getValue())){
//                reversedMap.put(entry.getValue(), reversedMap.get(entry.getValue()) + ", " + entry.getKey());
//            } else {
//                reversedMap.put(entry.getValue(), entry.getKey());
//            }
//        }
//        return reversedMap;
    }

    public Map<String, Integer> getFirstInitialCountMap(String fullNames) {
//        return Arrays.stream(fullNames.split(","))
//                .map(fullName -> String.valueOf(fullName.charAt(0)))
//                .collect(Collectors.groupingBy(identity(), Collectors.counting()));

        return Arrays.stream(fullNames.split(","))
                .map(fullName -> String.valueOf(fullName.charAt(0)))
                .collect(Collectors.toMap(identity(), count -> 1, Integer::sum));

//        String[] fullNamesArray = fullNames.split(",");
//        Map<String, Integer> initialCountMap = new HashMap<>();
//        for (String name:fullNamesArray) {
//            String initial = String.valueOf(name.charAt(0));
//            if(initialCountMap.containsKey(initial)){
//                initialCountMap.put(initial, initialCountMap.get(initial) + 1);
//            } else {
//                initialCountMap.put(initial, 1);
//            }
//        }
//        return initialCountMap;
    }

    public Map<String, Integer> getBothInitialsCountMap(String fullNames) {
        return Arrays.stream(fullNames.split(","))
                .map(fullName -> {
                    String[] name = fullName.split(" ");
                    return String.valueOf(name[0].charAt(0)) + String.valueOf(name[1].charAt(0));
                })
                .collect(Collectors.toMap(identity(), count -> 1, Integer::sum));
    }
}