package com.all.in.one.allinone.model.enums.turboAzEnums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum City {

    AGDAM("Ağdam", 4),
    AGDAS("Ağdaş", 6),
    AGDERE("Ağdərə", 5),
    AGSTAFA("Ağstafa", 8),
    AGSU("Ağsu", 10),
    ASTARA("Astara", 9),
    BABEK("Babək", 78),
    BAKI("Bakı", 1),
    BALAKEN("Balakən", 14),
    BEYLEQAN("Beyləqan", 13),
    BERDE("Bərdə", 12),
    BILESUVAR("Biləsuvar", 15),
    CEBRAYIL("Cəbrayıl", 26),
    CELILABAD("Cəlilabad", 25),
    CULFA("Culfa", 27),
    DASKESEN("Daşkəsən", 24),
    DELIMEMMEDLI("Dəliməmmədli", 23),
    FUZULI("Füzuli", 60),
    GEDEBEY("Gədəbəy", 36),
    GENCE("Gəncə", 2),
    GORANBOY("Goranboy", 18),
    GOYCAY("Göyçay", 17),
    GOYGOL("Göygöl", 19),
    GOYTEPE("Göytəpə", 20),
    HACIQABUL("Hacıqabul", 77),
    HORADIZ("Horadiz", 22),
    IMISLI("İmişli", 32),
    ISMAYILLI("İsmayıllı", 33),
    KELBECER("Kəlbəcər", 37),
    KURDEMIR("Kürdəmir", 41),
    LACIN("Laçın", 42),
    LERIK("Lerik", 43),
    LENKERAN("Lənkəran", 11),
    LIMAN("Liman", 44),
    MASALLI("Masallı", 45),
    MINGECEVIR("Mingəçevir", 46),
    NAFTALAN("Naftalan", 47),
    NAXCIVAN("Naxçıvan", 48),
    NEFTCALA("Neftçala", 49),
    OGUZ("Oğuz", 50),
    ORDUBAD("Ordubad", 51),
    QAX("Qax", 35),
    QAZAX("Qazax", 34),
    QEBELE("Qəbələ", 16),
    QOBUSTAN("Qobustan", 21),
    QUBA("Quba", 38),
    QUBADLI("Qubadlı", 39),
    QUSAR("Qusar", 40),
    SAATLI("Saatlı", 52),
    SABIRABAD("Sabirabad", 53),
    SABRAN("Şabran", 68),
    SAHBUZ("Şahbuz", 71),
    SALYAN("Salyan", 54),
    SAMAXI("Şamaxı", 73),
    SAMUX("Samux", 55),
    SEKI("Şəki", 72),
    SEMKIR("Şəmkir", 69),
    SERUR("Şərur", 70),
    SIRVAN("Şirvan", 74),
    SIYEZEN("Siyəzən", 56),
    SUMQAYIT("Sumqayıt", 3),
    SUSA("Şuşa", 75),
    TERTER("Tərtər", 58),
    TOVUZ("Tovuz", 57),
    UCAR("Ucar", 59),
    XACMAZ("Xaçmaz", 62),
    XANKENDI("Xankəndi", 61),
    XIRDALAN("Xırdalan", 67),
    XIZI("Xızı", 66),
    XOCALI("Xocalı", 64),
    XOCAVEND("Xocavənd", 63),
    XUDAT("Xudat", 65),
    YARDIMLI("Yardımlı", 76),
    YEVLAX("Yevlax", 28),
    ZAQATALA("Zaqatala", 29),
    ZENGILAN("Zəngilan", 30),
    ZERDAB("Zərdab", 31);

    private final String value;
    private final int id;

    City(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static City getCity(String value) {
        return Arrays.stream(City.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

}
