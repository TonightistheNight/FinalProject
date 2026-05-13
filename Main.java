//Parent class
class Character {
    public void  attack (){
        System.out.println("Character attacks!");
    }
}

//Child 1
class Warrior extends Character{
    @Override
    public void attack(){
        System.out.println("Warrior swings a sword!");
    }
}

//Child 2
class Archer extends Character {
    @Override
    public void attack(){
        System.out.println("Archer shoots an arrow!");
    }
}

//Child 3
class Wizard extends Character {
    @Override
    public void attack() {
        System.out.println("Wizard casts a fireball!");
    }
}
