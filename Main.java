//Parent class
class Character {
    public void train(){
        System.out.println("Character trains!");
    }
}

//Child 1
class Warrior extends Character{
    @Override
    public void train(){
        System.out.println("Warrior exercises!");
    }
}

//Child 2
class Archer extends Character {
    @Override
    public void train(){
        System.out.println("Archer perfects aim!");
    }
}

//Child 3
class Wizard extends Character {
    @Override
    public void train() {
        System.out.println("Wizard reads spellbook!");
    }
}

//Child 4
class Princess extends Character {
    @Override
        public void train(){
            System.out.println("Princess studies 'Strategy of War' book!")
    }
}

//Parent class
class Character {
    public void rest(){
        System.out.println("Character rests!");
    }
}

//Child 1
class Warrior extends Character{
    @Override
    public void rest(){
        System.out.println("Warrior takes a knee!");
    }
}

//Child 2
class Archer extends Character {
    @Override
    public void rest(){
        System.out.println("Archer sleeps in the trees!");
    }
}

//Child 3
class Wizard extends Character {
    @Override
    public void rest() {
        System.out.println("Wizard meditates!");
    }
}

//Child 4
class Princess extends Character {
    @Override
        public void rest(){
            System.out.println("Princess sleeps in her castle!")
    }
}

//Parent class
class Character {
    public void skill(){
        System.out.println("Character performs a skill!");
    }
}

//Child 1
class Warrior extends Character{
    @Override
    public void skill(){
        System.out.println("Warrior chops the head off an enemy!");
    }
}

//Child 2
class Archer extends Character {
    @Override
    public void skill(){
        System.out.println("Archer shoots an arrow");
    }
}

//Child 3
class Wizard extends Character {
    @Override
    public void skill() {
        System.out.println("Wizard casts a curse!");
    }
}

//Child 4
class Princess extends Character {
    @Override
        public void skill(){
            System.out.println("Princess smacks her enemy with her golden crown!")
    }
}
