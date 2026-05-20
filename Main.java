import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//===========================
// PARENT CLASS
//===========================
//This is the superclass that holds all the shared variables that EVERY character needs

class Character {
    String name;
    String gender;
    String species;
    String characterClass;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    String skills;
//empty constructor
    public Character() {
    }
    // getSheet() builds and RETURNS the full character sheet as one String
    //This is so the user can easily print it to the screen OR save it to a file.
    public String getSheet() {
        return "===== CHARACTER SHEET =====\n" +
                "Name: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Species: " + species + "\n" +
                "Class: " + characterClass + "\n\n" +
                "===== STATS =====\n" +
                "Strength: " + strength + "\n" +
                "Dexterity: " + dexterity + "\n" +
                "Constitution: " + constitution + "\n" +
                "Intelligence: " + intelligence + "\n" +
                "Wisdom: " + wisdom + "\n" +
                "Charisma: " + charisma + "\n\n" +
                "===== STARTER SKILLS =====\n" +
                skills + "\n";
    }
}

// ================= CHILD CLASSES (The 13 base D&D Classes)
//Each subclass extends Character to inherit the stats, but sets its own defaulted values.

class Artificer extends Character {
    public Artificer() {
        characterClass = "Artificer";
        strength = 8; dexterity = 10; constitution = 11; intelligence = 15; wisdom = 11; charisma = 10;
        skills = "Magical Tinkering, Arcane Repair, Tool Expertise";
    }
}

class Barbarian extends Character {
    public Barbarian() {
        characterClass = "Barbarian";
        strength = 15; dexterity = 11; constitution = 14; intelligence = 8; wisdom = 10; charisma = 9;
        skills = "Rage, Intimidation, Survival";
    }
}

class Bard extends Character {
    public Bard() {
        characterClass = "Bard";
        strength = 8; dexterity = 12; constitution = 10; intelligence = 11; wisdom = 10; charisma = 15;
        skills = "Performance, Inspiration, Persuasion";
    }
}

class Cleric extends Character {
    public Cleric() {
        characterClass = "Cleric";
        strength = 10; dexterity = 9; constitution = 12; intelligence = 10; wisdom = 15; charisma = 11;
        skills = "Healing Prayer, Divine Sense, Bless";
    }
}

class Druid extends Character {
    public Druid() {
        characterClass = "Druid";
        strength = 9; dexterity = 11; constitution = 10; intelligence = 12; wisdom = 15; charisma = 9;
        skills = "Nature Bond, Wild Shape, Herbal Lore";
    }
}

class Fighter extends Character {
    public Fighter() {
        characterClass = "Fighter";
        strength = 14; dexterity = 12; constitution = 13; intelligence = 9; wisdom = 10; charisma = 9;
        skills = "Weapon Mastery, Second Wind, Guard Stance";
    }
}

class Monk extends Character {
    public Monk() {
        characterClass = "Monk";
        strength = 10; dexterity = 15; constitution = 11; intelligence = 10; wisdom = 14; charisma = 8;
        skills = "Martial Arts, Focus Strike, Quick Step";
    }
}

class Paladin extends Character {
    public Paladin() {
        characterClass = "Paladin";
        strength = 14; dexterity = 9; constitution = 13; intelligence = 9; wisdom = 11; charisma = 14;
        skills = "Divine Smite, Lay on Hands, Holy Oath";
    }
}

class Ranger extends Character {
    public Ranger() {
        characterClass = "Ranger";
        strength = 11; dexterity = 14; constitution = 11; intelligence = 10; wisdom = 13; charisma = 9;
        skills = "Tracking, Archery, Beast Knowledge";
    }
}

class Rogue extends Character {
    public Rogue() {
        characterClass = "Rogue";
        strength = 8; dexterity = 15; constitution = 10; intelligence = 12; wisdom = 10; charisma = 11;
        skills = "Stealth, Sneak Attack, Lockpicking";
    }
}

class Sorcerer extends Character {
    public Sorcerer() {
        characterClass = "Sorcerer";
        strength = 8; dexterity = 11; constitution = 10; intelligence = 10; wisdom = 9; charisma = 15;
        skills = "Spellcasting, Arcane Burst, Bloodline Power";
    }
}

class Warlock extends Character {
    public Warlock() {
        characterClass = "Warlock";
        strength = 8; dexterity = 10; constitution = 11; intelligence = 11; wisdom = 9; charisma = 15;
        skills = "Eldritch Blast, Pact Magic, Dark Insight";
    }
}

class Wizard extends Character {
    public Wizard() {
        characterClass = "Wizard";
        strength = 7; dexterity = 10; constitution = 9; intelligence = 16; wisdom = 12; charisma = 9;
        skills = "Spellbook, Arcane Study, Magic Missile";
    }
}
public class Main {
    // Here static means there is only one copy of it for the entire class,
    // rather than a separate copy for every object we create
    static String selectedSpecies = "";
    static String selectedClass = "";
    static Character currentCharacter = null;

    // Arrays holding the names of our character species and class options

    static String[] speciesList = {
            "Aasimar", "Dragonborn", "Dwarf", "Elf", "Gnome",
            "Goliath", "Halfling", "Human", "Orc", "Tiefling"
    };

    static String[] classList = {
            "Artificer", "Barbarian", "Bard", "Cleric", "Druid",
            "Fighter", "Monk", "Paladin", "Ranger", "Rogue",
            "Sorcerer", "Warlock", "Wizard"
    };

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        // JFrame = actual window the user sees on their screen
        JFrame frame = new JFrame("DND Character Creator");
        frame.setSize(700, 500);
        // This makes the whole program close when the user clicks the X button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JLabel title = new JLabel("DND Character Creator Catalogue", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        //"SwingConstants" is a built in Java tool that holds spacial alignment words
// such as North, South, East, West, Left Right and Center.
// Had a bit of a struggle here, didn't know how to bring the Title to the center of the Jlabel.

        // NOTE: I changed the JTextArea to a JLabel to make it easier to center align the fixed instructions

        JLabel infoArea = new JLabel("", SwingConstants.CENTER);
        // By starting with <html>, we can use <br> for new lines and <center> to center the text
        infoArea.setText("<html><center>Welcome!<br><br>Build your D&D character by:<br>" +
                "1. Viewing and selecting a species<br>" +
                "2. Viewing and selecting a class<br>" +
                "3. Entering your character's name and gender<br>" +
                "4. Saving the finished character to a file</center></html>");

        infoArea.setFont(new Font("Calibri", Font.PLAIN, 25));

        // Create the users buttons
        JButton speciesButton = new JButton("Open Species Menu");
        JButton classButton = new JButton("Open Class Menu");
        JButton createButton = new JButton("Create Character");
        JButton loadButton = new JButton("Load Character File");

        // GridLayout arranges items in a grid. (Rows, Columns, a horizontal gap, vertical gap.)
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.add(speciesButton);
        buttonPanel.add(classButton);
        buttonPanel.add(createButton);
        buttonPanel.add(loadButton);

        JPanel centeredButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeredButtonPanel.add(buttonPanel);


        // Add the pieces into the BorderLayout zones

        frame.add(title, BorderLayout.NORTH);
        frame.add(infoArea, BorderLayout.CENTER);
        frame.add(centeredButtonPanel, BorderLayout.SOUTH);
// Action Listeners wait for the user to click the button, then run the code inside
        // "e ->" is a "lambda" expression, which is just a shortcut way of writing a listener
        speciesButton.addActionListener(e -> showSpeciesMenu());
        classButton.addActionListener(e -> showClassMenu());
        createButton.addActionListener(e -> showCreateCharacterMenu());
        loadButton.addActionListener(e -> loadCharacterFile());
// Makes the window actually appear on the screen
        frame.setVisible(true);
    }

    public static void showSpeciesMenu() {
        JFrame frame = new JFrame("Species Menu");
        frame.setSize(1000, 400);
        frame.setLayout(new BorderLayout());

        JList<String> speciesJList = new JList<>(speciesList);
        // NOTE: This restricts the list height so it doesn't leave a massive gap
        speciesJList.setVisibleRowCount(10);

        JScrollPane scrollPane = new JScrollPane(speciesJList);

        // NOTE: We wrap the list in a panel pinned to the NORTH so it doesn't stretch to the bottom
        JPanel listWrapper = new JPanel(new BorderLayout());
        listWrapper.add(scrollPane, BorderLayout.NORTH);

        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Arial", Font.PLAIN, 22));

        JButton viewButton = new JButton("View Info");
        JButton selectButton = new JButton("Select Species");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewButton);
        buttonPanel.add(selectButton);

        // NOTE: We add 'listWrapper' instead of 'scrollPane' to the WEST zone
        frame.add(listWrapper, BorderLayout.WEST);
        frame.add(infoArea, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // When "View" Button is clicked, get the highlighted word from the list and find its info
        viewButton.addActionListener(e -> {
            String selected = speciesJList.getSelectedValue();
            if (selected != null) {
                infoArea.setText(getSpeciesInfo(selected));
            }
        });

        selectButton.addActionListener(e -> {
            String selected = speciesJList.getSelectedValue();
            if (selected != null) {
                selectedSpecies = selected;
                JOptionPane.showMessageDialog(frame, selected + " selected!");
            }
        });

        frame.setVisible(true);
    }

    public static void showClassMenu() {
        JFrame frame = new JFrame("Class Menu");
        frame.setSize(650, 450);
        frame.setLayout(new BorderLayout());

        JList<String> classJList = new JList<>(classList);
        // Note: This restricts the list height so it doesn't leave a massive gap
        classJList.setVisibleRowCount(13);

        JScrollPane scrollPane = new JScrollPane(classJList);

        // Note: This wraps the list in a panel pinned to the NORTH so it doesn't stretch to the bottom
        JPanel listWrapper = new JPanel(new BorderLayout());
        listWrapper.add(scrollPane, BorderLayout.NORTH);

        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Arial", Font.PLAIN, 22));

        JButton viewButton = new JButton("View Info");
        JButton selectButton = new JButton("Select Class");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewButton);
        buttonPanel.add(selectButton);

        // NOTE: We add 'listWrapper' instead of 'scrollPane' to the WEST zone
        frame.add(listWrapper, BorderLayout.WEST);
        frame.add(infoArea, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        viewButton.addActionListener(e -> {
            String selected = classJList.getSelectedValue();
            if (selected != null) {
                infoArea.setText(getClassInfo(selected));
            }
        });

        selectButton.addActionListener(e -> {
            String selected = classJList.getSelectedValue();
            if (selected != null) {
                selectedClass = selected;
                JOptionPane.showMessageDialog(frame, selected + " selected!");
            }
        });

        frame.setVisible(true);
    }


    public static void showCreateCharacterMenu() {
        // prevents the user from building a character if they haven't picked the basics yet.
        if (selectedSpecies.equals("") || selectedClass.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a species and class first.");
            return;
        }

        JFrame frame = new JFrame("Create Character");
        frame.setSize(450, 300);
        frame.setLayout(new GridLayout(5, 2, 10, 10));
// GridLayout(5, 2, 10, 10)
// 5 rows
// 2 columns
// 10 pixels horizontal gap
// 10 pixels vertical gap
        JLabel nameLabel = new JLabel("Character Name:");
        JTextField nameField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        String[] genders = {"Male", "Female", "Other"};

        // JComboBox is command for a dropdown menu

        JComboBox<String> genderBox = new JComboBox<>(genders);

        JLabel speciesLabel = new JLabel("Selected Species:");
        JLabel speciesValue = new JLabel(selectedSpecies);

        JLabel classLabel = new JLabel("Selected Class:");
        JLabel classValue = new JLabel(selectedClass);

        JButton finishButton = new JButton("Finish Character");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(genderLabel);
        frame.add(genderBox);
        frame.add(speciesLabel);
        frame.add(speciesValue);
        frame.add(classLabel);
        frame.add(classValue);
        frame.add(new JLabel());  //Empty label to fill a spot in the grid
        frame.add(finishButton);

        finishButton.addActionListener(e -> {
            String charName = nameField.getText().trim();
            String gender = (String) genderBox.getSelectedItem();
// Grabs whatever was in the drop-down menu array
            if (charName.equals("")) {
                JOptionPane.showMessageDialog(frame, "Please enter a character name.");
                return;
            }

            currentCharacter = createClassObject(selectedClass);
            currentCharacter.name = charName;
            currentCharacter.gender = gender;
            currentCharacter.species = selectedSpecies;

            applySpeciesBonus(currentCharacter, selectedSpecies);

            showCharacterSheet(currentCharacter);
            saveCharacterToFile(currentCharacter);
        });

        frame.setVisible(true);
    }

    public static Character createClassObject(String className) {
        switch (className) {
            case "Artificer": return new Artificer();
            case "Barbarian": return new Barbarian();
            case "Bard": return new Bard();
            case "Cleric": return new Cleric();
            case "Druid": return new Druid();
            case "Fighter": return new Fighter();
            case "Monk": return new Monk();
            case "Paladin": return new Paladin();
            case "Ranger": return new Ranger();
            case "Rogue": return new Rogue();
            case "Sorcerer": return new Sorcerer();
            case "Warlock": return new Warlock();
            default: return new Wizard();
        }
    }

    public static void applySpeciesBonus(Character c, String species) {
        switch (species) {
            case "Aasimar":
                c.charisma += 2;
                c.wisdom += 1;
                break;
            case "Dragonborn":
                c.strength += 2;
                c.charisma += 1;
                break;
            case "Dwarf":
                c.constitution += 2;
                break;
            case "Elf":
                c.dexterity += 2;
                break;
            case "Gnome":
                c.intelligence += 2;
                break;
            case "Goliath":
                c.strength += 2;
                c.constitution += 1;
                break;
            case "Halfling":
                c.dexterity += 2;
                break;
            case "Human":
                c.strength += 1;
                c.dexterity += 1;
                c.constitution += 1;
                c.intelligence += 1;
                c.wisdom += 1;
                c.charisma += 1;
                break;
            case "Orc":
                c.strength += 2;
                c.constitution += 1;
                break;
            case "Tiefling":
                c.charisma += 2;
                c.intelligence += 1;
                break;
        }
    }

    public static void showCharacterSheet(Character c) {
        JFrame frame = new JFrame("Character Sheet");
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        JTextArea sheetArea = new JTextArea();
        sheetArea.setEditable(false);
        sheetArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        sheetArea.setText(c.getSheet());

        JScrollPane scrollPane = new JScrollPane(sheetArea);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void saveCharacterToFile(Character c) {
        try {
            String fileName = c.name + ".txt";
            FileWriter writer = new FileWriter(fileName);
            writer.write(c.getSheet());
            writer.close();
            JOptionPane.showMessageDialog(null, "Character saved to " + fileName);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving character file.");
        }
    }

    public static void loadCharacterFile() {
        String fileName = JOptionPane.showInputDialog("Enter the character file name (example: Bob.txt)");
        if (fileName == null || fileName.trim().equals("")) {
            return;
        }

        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            StringBuilder content = new StringBuilder();

            while (input.hasNextLine()) {
                content.append(input.nextLine()).append("\n");
            }
            input.close();

            JFrame frame = new JFrame("Loaded Character");
            frame.setSize(500, 500);

            JTextArea area = new JTextArea();
            area.setEditable(false);
            area.setFont(new Font("Monospaced", Font.PLAIN, 15));
            area.setText(content.toString());

            frame.add(new JScrollPane(area));
            frame.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File not found.");
        }
    }

    public static String getSpeciesInfo(String species) {
        switch (species) {
            case "Aasimar":
                return "Aasimar\n\nCelestial-touched people with radiant ancestry. \nDescended from humans. Still fundamentally mortal.\nBonus: +2 Charisma, +1 Wisdom";
            case "Dragonborn":
                return "Dragonborn\n\nDraconic (Dragon-like) humanoids with scales, known for pride, strength, and presence.\n(Essentially just lizard people, and can't fly.) \nBonus: +2 Strength, +1 Charisma";
            case "Dwarf":
                return "Dwarf\n\nDurable and sturdy people known for resilience. \nRenowned for constructing deep mountainous cities and are some of the best black smiths. \nBonus: +2 Constitution";
            case "Elf":
                return "Elf\n\nGraceful and keen-sensed people with natural agility.\nBonus: +2 Dexterity";
            case "Gnome":
                return "Gnome\n\nSmall clever and curious people with sharp minds.\nBonus: +2 Intelligence";
            case "Goliath":
                return "Goliath\n\nTowering mountain folk with great power and endurance.\nBonus: +2 Strength, +1 Constitution";
            case "Halfling":
                return "Halfling\n\nSmall, quick, and lucky adventurers.\nBonus: +2 Dexterity";
            case "Human":
                return "Human\n\nAdaptable and versatile people with balanced growth.\nBonus: +1 to all stats";
            case "Orc":
                return "Orc\n\nPowerful and intimidating warriors with physical toughness.\nBonus: +2 Strength, +1 Constitution";
            default:
                return "Tiefling\n\nInfernal-blooded people with strong will and magic potential.\nBonus: +2 Charisma, +1 Intelligence";
        }
    }

    public static String getClassInfo(String className) {
        switch (className) {
            case "Artificer":
                return "Artificer\n\nA magical inventor who combines tools and arcane power.\nStarter Skills: Magical Tinkering, Arcane Repair, Tool Expertise";
            case "Barbarian":
                return "Barbarian\n\nA fierce warrior powered by rage and toughness.\nStarter Skills: Rage, Intimidation, Survival";
            case "Bard":
                return "Bard\n\nA performer and support caster who inspires others.\nStarter Skills: Performance, Inspiration, Persuasion";
            case "Cleric":
                return "Cleric\n\nA divine caster focused on faith, healing, and blessings.\nStarter Skills: Healing Prayer, Divine Sense, Bless";
            case "Druid":
                return "Druid\n\nA nature-focused caster tied to beasts and the wild.\nStarter Skills: Nature Bond, Wild Shape, Herbal Lore";
            case "Fighter":
                return "Fighter\n\nA disciplined weapon specialist with strong combat basics.\nStarter Skills: Weapon Mastery, Second Wind, Guard Stance";
            case "Monk":
                return "Monk\n\nA martial artist who uses speed, discipline, and focus.\nStarter Skills: Martial Arts, Focus Strike, Quick Step";
            case "Paladin":
                return "Paladin\n\nA holy warrior guided by justice and divine power.\nStarter Skills: Divine Smite, Lay on Hands, Holy Oath";
            case "Ranger":
                return "Ranger\n\nA wilderness hunter skilled in tracking and ranged combat.\nStarter Skills: Tracking, Archery, Beast Knowledge";
            case "Rogue":
                return "Rogue\n\nA stealthy expert in trickery, speed, and precision.\nStarter Skills: Stealth, Sneak Attack, Lockpicking";
            case "Sorcerer":
                return "Sorcerer\n\nA natural spellcaster whose power comes from bloodline or talent.\nStarter Skills: Spellcasting, Arcane Burst, Bloodline Power";
            case "Warlock":
                return "Warlock\n\nA caster who gains magic through a supernatural pact.\nStarter Skills: Eldritch Blast, Pact Magic, Dark Insight";
            default:
                return "Wizard\n\nA scholarly arcane caster who learns magic through study.\nStarter Skills: Spellbook, Arcane Study, Magic Missile";
        }
    }
}
