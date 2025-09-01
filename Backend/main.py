import pandas as pd
from catboost import CatBoostRegressor
from fastapi import FastAPI
from pydantic import BaseModel

class Araba(BaseModel):
    sehir: str
    marka: str
    seri: str
    model: str
    yil: int
    kilometre: int
    renk: str
    vitesTipi: str
    yakitTipi: str
    kasaTipi: str
    motorHacmi: float
    motorGucu: float
    cekis: str
    ortYakit: float
    yakitDeposu: float
    boya: int
    degisen: int
    tramer: float

app = FastAPI()
model = CatBoostRegressor()
model.load_model("araba_fiyat_model.cbm")

@app.post("/araba")
async def araba_ekle(araba: Araba):
    data=pd.DataFrame([{ "konum": araba.sehir,
                         "marka": araba.marka,
                         "seri": araba.seri,
                         "model": araba.model,
                         "yil": araba.yil,
                         "kilometre": araba.kilometre,
                         "vites_tipi": araba.vitesTipi,
                         "yakit_tipi": araba.yakitTipi,
                         "kasa_tipi": araba.kasaTipi,
                         "renk": araba.renk,
                         "motor_hacmi": araba.motorHacmi,
                         "motor_gucu": araba.motorGucu,
                         "cekis": araba.cekis,
                         "ortalama_yakit_tuketimi": araba.ortYakit,
                         "yakit_deposu": araba.yakitDeposu,
                         "tramer": araba.tramer,
                         "degisen": araba.degisen,
                         "boya": araba.boya }])



    sonuc = model.predict(data)
    if float(sonuc[0]):
        return {"fiyat": float(sonuc[0])}
    else:
        return {"fiyat": float(0)}