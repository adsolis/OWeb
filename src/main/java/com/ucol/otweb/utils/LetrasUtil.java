/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author 
 */
public class LetrasUtil {

    static public int flag = 0;

    static public String convertirNumeroALetras(Number cantidad) {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("ES","MX"));
        DecimalFormat num = (DecimalFormat)nf;
        //DecimalFormat num = new DecimalFormat("###.00");
        num.applyPattern("###.00");
        num.format(cantidad);
        String montoTotal =num.format(cantidad);
        int tamanoCadena = montoTotal.length();
        int indiceEntero = montoTotal.lastIndexOf(".");
        String montoEntero = "";
        String montoDecimal = "";
        String numeroEnLetras = "";
        if (indiceEntero != -1) {
            montoEntero = montoTotal.substring(0, indiceEntero);
            if ((tamanoCadena - (indiceEntero + 1)) == 2) {
                if (montoTotal.substring(indiceEntero + 2, tamanoCadena).equals("0")) {
                    montoDecimal = montoTotal.substring(indiceEntero + 1, tamanoCadena) + "0";
                } else {
                    montoDecimal = montoTotal.substring(indiceEntero + 1, tamanoCadena);
                }
            } else {
                montoDecimal = montoTotal.substring(indiceEntero + 1, tamanoCadena) + "0";;
            }

        } else {
            montoEntero = montoTotal;
            montoDecimal = "00";
        }
        numeroEnLetras = convertirALetras(Integer.parseInt(montoEntero))+Constants.PESOS+" "+montoDecimal+Constants.FORMATO_PESOS_MEX;
        return numeroEnLetras;
    }

    static private String convertirALetras(Integer cantidas) {
        String nombreNumero = "";
        nombreNumero=deciMillones(cantidas);
        return nombreNumero;
    }

    static private String deciMillones(Integer numero) {
        String deciMillones = "";
        if (numero == 10000000) {
            deciMillones = "diez millones";
        }
        if (numero > 10000000 && numero < 20000000) {
            flag = 1;
            deciMillones = decena(numero / 1000000).concat("millones ").concat(cienMiles(numero % 1000000));
        }
        if (numero >= 20000000 && numero < 100000000) {
            flag = 1;
            deciMillones = decena(numero / 1000000).concat(" millones ").concat(millon(numero % 1000000));
        }


        if (numero < 10000000) {
            deciMillones = millon(numero);
        }

        return deciMillones;
    }

    static private String millon(Integer numero) {
        String millon = "";
        if (numero >= 1000000 && numero < 2000000) {
            flag = 1;
            millon = ("Un millon ").concat(cienMiles(numero % 1000000));
        }
        if (numero >= 2000000 && numero < 10000000) {
            flag = 1;
            millon = unidad(numero / 1000000).concat(" millones ").concat(cienMiles(numero % 1000000));
        }
        if (numero < 1000000) {
            millon = cienMiles(numero);
        }

        return millon;
    }

    static private String cienMiles(Integer numero) {
        String cienMiles = "";
        if (numero == 100000) {
            cienMiles = "cien mil";
        }
        if (numero >= 100000 && numero < 1000000) {
            flag = 1;
            cienMiles = centena(numero / 1000).concat(" mil ").concat(centena(numero % 1000));
        }
        if (numero < 100000) {
            cienMiles = decMiles(numero);
        }
        return cienMiles;
    }

    static private String decMiles(Integer numero) {
        String decMiles = "";
        if (numero == 10000) {
            decMiles = "diez mil";
        }
        if (numero > 10000 && numero < 20000) {
            flag = 1;
            decMiles = decena(numero / 1000).concat("mil ").concat(centena(numero % 1000));
        }
        if (numero >= 20000 && numero < 100000) {
            flag = 1;
            decMiles = decena(numero / 1000).concat(" mil ").concat(miles(numero % 1000));
        }


        if (numero < 10000) {
            decMiles = miles(numero);
        }
        return decMiles;
    }

    static private String miles(Integer numero) {
        String miles = "";
        if (numero >= 1000 && numero < 2000) {
            miles = ("mil ").concat(centena(numero % 1000));
        }
        if (numero >= 2000 && numero < 10000) {
            flag = 1;
            miles = unidad(numero / 1000).concat(" mil ").concat(centena(numero % 1000));
        }
        if (numero < 1000) {
            miles = centena(numero);
        }

        return miles;
    }

    static private String centena(Integer numero) {
        String centena = "";
        if (numero >= 100) {
            if (numero >= 900 && numero <= 999) {
                centena = "novecientos ";
                if (numero > 900) {
                    centena = centena.concat(decena(numero - 900));
                }
            } else if (numero >= 800 && numero <= 899) {
                centena = "ochocientos ";
                if (numero > 800) {
                    centena = centena.concat(decena(numero - 800));
                }
            } else if (numero >= 700 && numero <= 799) {
                centena = "setecientos ";
                if (numero > 700) {
                    centena = centena.concat(decena(numero - 700));
                }
            } else if (numero >= 600 && numero <= 699) {
                centena = "seiscientos ";
                if (numero > 600) {
                    centena = centena.concat(decena(numero - 600));
                }
            } else if (numero >= 500 && numero <= 599) {
                centena = "quinientos ";
                if (numero > 500) {
                    centena = centena.concat(decena(numero - 500));
                }
            } else if (numero >= 400 && numero <= 499) {
                centena = "cuatrocientos ";
                if (numero > 400) {
                    centena = centena.concat(decena(numero - 400));
                }
            } else if (numero >= 300 && numero <= 399) {
                centena = "trescientos ";
                if (numero > 300) {
                    centena = centena.concat(decena(numero - 300));
                }
            } else if (numero >= 200 && numero <= 299) {
                centena = "doscientos ";
                if (numero > 200) {
                    centena = centena.concat(decena(numero - 200));
                }
            } else if (numero >= 100 && numero <= 199) {
                if (numero == 100) {
                    centena = "cien ";
                } else {
                    centena = "ciento ".concat(decena(numero - 100));
                }
            }
        } else {
            centena = decena(numero);
        }
        return centena;
    }

    static private String decena(Integer numero) {
        String decena = "";

        if (numero >= 90 && numero <= 99) {
            decena = "noventa ";
            if (numero > 90) {
                decena = decena.concat("y ").concat(unidad(numero - 90));
            }
        } else if (numero >= 80 && numero <= 89) {
            decena = "ochenta ";
            if (numero > 80) {
                decena = decena.concat("y ").concat(unidad(numero - 80));
            }
        } else if (numero >= 70 && numero <= 79) {
            decena = "setenta ";
            if (numero > 70) {
                decena = decena.concat("y ").concat(unidad(numero - 70));
            }
        } else if (numero >= 60 && numero <= 69) {
            decena = "sesenta ";
            if (numero > 60) {
                decena = decena.concat("y ").concat(unidad(numero - 60));
            }
        } else if (numero >= 50 && numero <= 59) {
            decena = "cincuenta ";
            if (numero > 50) {
                decena = decena.concat("y ").concat(unidad(numero - 50));
            }
        } else if (numero >= 40 && numero <= 49) {
            decena = "cuarenta ";
            if (numero > 40) {
                decena = decena.concat("y ").concat(unidad(numero - 40));
            }
        } else if (numero >= 30 && numero <= 39) {
            decena = "treinta ";
            if (numero > 30) {
                decena = decena.concat("y ").concat(unidad(numero - 30));
            }
        } else if (numero >= 20 && numero <= 29) {
            if (numero == 20) {
                decena = "veinte ";
            } else {
                decena = "veinti".concat(unidad(numero - 20));
            }
        } else if (numero >= 10 && numero <= 19) {
            switch (numero) {
                case 10:

                    decena = "diez ";
                    break;

                case 11:

                    decena = "once ";
                    break;

                case 12:

                    decena = "doce ";
                    break;

                case 13:

                    decena = "trece ";
                    break;

                case 14:

                    decena = "catorce ";
                    break;

                case 15:

                    decena = "quince ";
                    break;

                case 16:

                    decena = "dieciseis ";
                    break;

                case 17:

                    decena = "diecisiete ";
                    break;

                case 18:

                    decena = "dieciocho ";
                    break;

                case 19:

                    decena = "diecinueve ";
                    break;

            }
        } else {
            decena = unidad(numero);
        }
        return decena;
    }

    static private String unidad(Integer numero) {
        String unidad = "";
        if (numero == 9) {
            unidad = "nueve";
        }
        if (numero == 8) {
            unidad = "ocho";
        }
        if (numero == 7) {
            unidad = "siete";
        }
        if (numero == 6) {
            unidad = "seis";
        }
        if (numero == 5) {
            unidad = "cinco";
        }
        if (numero == 4) {
            unidad = "cuatro";
        }
        if (numero == 3) {
            unidad = "tres";
        }
        if (numero == 2) {
            unidad = "dos";
        }
        if (numero == 1) {
            if (flag == 0) {
                unidad = "uno";
            } else {
                unidad = "un";
            }
        }
        if (numero == 0) {
            unidad = "";
        }
        return unidad;
    }
}
