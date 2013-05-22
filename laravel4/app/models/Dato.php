<?php

class Dato extends EloquentMongo {

    protected $guarded = array();

    public static $rules = array();

    public $timestamps = false;

    protected $collection = 'datos';

}
