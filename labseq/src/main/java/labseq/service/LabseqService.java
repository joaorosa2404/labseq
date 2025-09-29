package labseq.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;

@ApplicationScoped
public class LabseqService {

    private BigInteger[] cache;

    public LabseqService(){
        cache = new BigInteger[10000]; //cria um array para guardar os valores já calculados
        Arrays.fill(cache, null); //coloca todos os valores a null
    }

    public BigInteger getLabseq(int num){
        if(num < 0){ //se for um numero negativo, dá erro
            throw new IllegalArgumentException("O número deve ser positivo");
        }

        if(num >= cache.length){ //se o numero for maior do que o numero de valores na cache, aumenta o array para esse numero
            cache = Arrays.copyOf(cache, num+1);
        }

        if(cache[num] != null){ //se o valor já existir no array, retorna de imediato
            return cache[num];
        }

        if (num == 0 || num == 2) {
            return BigInteger.ZERO;
        } else if (num == 1 || num == 3) {
            return BigInteger.ONE;
        } else { //retorna sempre o valor em cache, para guarda-lo automaticamente
            cache[num] = getLabseq(num-4).add(getLabseq(num-3));
            return cache[num];

        }
    }

    //metodo para limpar o array, caso seja necessario
    public void resetCache(){
        cache = new BigInteger[10000];
        Arrays.fill(cache, null);
    }
}
