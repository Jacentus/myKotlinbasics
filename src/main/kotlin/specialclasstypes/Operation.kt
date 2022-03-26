package specialclasstypes

// podobna do enum, dostarcza dodatkowo możliwości przechwytywania
// klasa abstrakcyjna, nie możemy robić obiektów
// w pliku, w którym jest zdefiniowana, powinny znajdować się jej klasy pochodne (takie enumy o większych możliwościach)

sealed class Operation

    class Add(val value : Int) : Operation() //wartość "enumowa"

class Multiply(val value: Int) : Operation()

// inny sposób:

/*
sealed class Operation

class Add(val value : Int) : Operation()
class Multiply(val value: Int) : Operation()*/
