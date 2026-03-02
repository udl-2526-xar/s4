# Sessió 4 (03/03)

## Treballar amb variables compartides entre threads

---

## Part 1

Crea una classe `SharedUnsafe.java` que faci:

- Declara una variable privada `int x` de classe amb valor `0`.

### El mètode `main`:

- Crea un thread `t1` que llenci una instància de la classe `Adder`.
- Crea un thread `t2` que llenci una instància de la classe `Adder`.
- Engega els threads.
- Espera que acabin els threads.
- Mostra el resultat de `x`.

### La classe `Adder` (interna a `SharedUnsafe`):

- Ha d’estar definida dins la classe anterior per tal de poder accedir a `x`.
- Ha de fer un bucle de `0` a `500.000`.
- Dins el bucle:
    - Incrementa `x` en `1`.

**Raona el valor de `x`.**

### Altres classes d’aquest repositori:

- `SharedVolatile`: Versió modificada de `SharedUnsafe` utilitzant `volatile`, però que **no** soluciona el problema.

---

## Part 2

Crea una classe `SharedAtomic.java` que:

- Tingui el mateix comportament que `SharedUnsafe.java`.
- Modifiqui la variable `x` perquè deixi de ser `int` i passi a ser `AtomicInteger`.
- Adapti el codi de la classe `Adder` que sigui necessari.

**Raona el valor de `x`.**

---

## Part 3 – Homework

Una vegada vista la classe `SharedSync.java` a classe, fes la següent modificació:

- Afegeix una nova classe `Decrementer.java` similar a `Adder.java`, però que en comptes de sumar, resti a cada volta del bucle.
- Assegura’t que està tancada amb `synchronized`.
- Revisa / prova si has d’utilitzar el mateix objecte o un altre per sincronitzar-te entre classes.
- Afegeix un nou thread a `main()` que cridi aquesta nova classe.

**El resultat de `x` hauria de ser 500.000? (500.000 + 500.000 - 500.000).**