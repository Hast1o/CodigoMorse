import java.util.ArrayList;
import java.util.Scanner;

class Nodo {
    Nodo izquierdo;
    Nodo derecho;
    char letra;
    String codigo;

    Nodo(char _letra, String _codigo) {
        this.izquierdo = null;
        this.derecho = null;
        this.letra = _letra;
        this.codigo = _codigo;
    }
}

class Pares {
    char letra;
    String Clave;

    Pares(char _letra, String _clave) {
        this.setLetra(_letra);
        this.setClave(_clave);
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char _letra) {
        letra = _letra;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String _clave) {
        Clave = _clave;
    }
}

class Arbol {
    Nodo raiz;

    Arbol(ArrayList<Pares> _letras) {
        raiz = null;
        for (Pares pares : _letras) {
            insersionNormal(pares.getLetra(), pares.getClave());
        }
    }

    public void insersionNormal(char _letra, String _codigo) {
        raiz = insersionRecursiva(raiz, _letra, _codigo);
    }

    public Nodo insersionRecursiva(Nodo _raiz, char _letra, String _codigo) {
        if (_raiz == null) {
            _raiz = new Nodo(_letra, _codigo);
            return _raiz;
        } else {
            if (_letra < _raiz.letra) {
                _raiz.izquierdo = insersionRecursiva(_raiz.izquierdo, _letra, _codigo);
            } else {
                if (_letra > _raiz.letra) {
                    _raiz.derecho = insersionRecursiva(_raiz.derecho, _letra, _codigo);
                }
            }
        }
        return _raiz;
    }

    public char obtenerCodigo(String _codigo) {
        return obtenerRecursivo(raiz, _codigo);
    }

    public char obtenerRecursivo(Nodo _raiz, String _codigo) {
        if (_raiz == null) {
            return ' ';
        } else {
            if (_codigo.equals(_raiz.codigo)) {
                return _raiz.letra;
            } else {
                System.out.println("hola");
                if (_codigo.compareTo(_raiz.codigo) < 0) {
                    return obtenerRecursivo(_raiz.izquierdo, _codigo);
                } else {
                    return obtenerRecursivo(_raiz.derecho, _codigo);
                }
            }
        }
    }

    public String descifrado(String _palabraMorse) {
        StringBuilder palabraDescifrada = new StringBuilder();
        String[] letras = _palabraMorse.split("\\s+");
        for (String letra : letras) {
            char caracter = obtenerCodigo(letra);
            System.out.println(caracter);
            palabraDescifrada.append(caracter);
        }
        return palabraDescifrada.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Pares> Letras = new ArrayList<>();
        Letras.add(new Pares('E', "."));
        Letras.add(new Pares('T', "-"));
        Letras.add(new Pares('A', ".-"));
        Letras.add(new Pares('I', ".."));
        Letras.add(new Pares('N', "-."));
        Letras.add(new Pares('M', "--"));
        Letras.add(new Pares('S', "..."));
        Letras.add(new Pares('U', "..-"));
        Letras.add(new Pares('R', ".-."));
        Letras.add(new Pares('W', ".--"));
        Letras.add(new Pares('D', "-.."));
        Letras.add(new Pares('K', "-.-"));
        Letras.add(new Pares('G', "--."));
        Letras.add(new Pares('O', "---"));
        Letras.add(new Pares('H', "...."));
        Letras.add(new Pares('V', "...-"));
        Letras.add(new Pares('F', "..-."));
        Letras.add(new Pares('L', ".-.."));
        Letras.add(new Pares('P', ".--."));
        Letras.add(new Pares('J', ".---"));
        Letras.add(new Pares('B', "-..."));
        Letras.add(new Pares('X', "-..-"));
        Letras.add(new Pares('C', "-.-."));
        Letras.add(new Pares('Y', "-.--"));
        Letras.add(new Pares('Z', "--.."));
        Letras.add(new Pares('Q', "--.-"));

        for (Pares pares : Letras) {
            System.out.println("Letra "+pares.letra+" Codigo "+pares.Clave);
        }

        Arbol arbolMorse = new Arbol(Letras);
        System.out.println("Digite una clave");
        String clave = in.nextLine();
        System.out.println(clave);
        String palabraDescifrada = arbolMorse.descifrado(clave);
        System.out.println(palabraDescifrada);
    }
}
