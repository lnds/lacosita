<?php

class CosaController extends \BaseController {

    const N = 9007199254740992;

    //list
    public function getCreate()
    {
        LMongo::connection()->datos->ensureIndex(['codigo' => 1], ["unique" => true, "dropDups" => true ]);

        $codigo = $this->getCodigo();
        $datos = [];
        for ($i = 0; $i < 10; $i++) {
            $data = [
                'codigo' => $codigo,
                'nombre' => "dato ${codigo}",
                'cuando' => date("Y-m-d H:i:s")//new DateTime
            ];
            Dato::create($data);
            array_push($datos, $data);
            $codigo++;
        }
        return $datos;
    }

    //list
    public function getList()
    {
        $codigo = $this->getCodigo();
        return Dato::whereGt("codigo", $codigo)
                        ->take(10)
                        ->get();
    }

    //json-list
    public function getJsonList()
    {
        $codigo = $this->getCodigo();
        $datos = Dato::whereGt("codigo", $codigo)
                        ->take(10)
                        ->get();

        return View::make('list')->with( compact('datos') );
    }

    private function getCodigo()
    {
        return rand(0, self::N);
    }
 }