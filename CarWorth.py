import requests
from bs4 import BeautifulSoup
import random

iller = [
    "adana", "adiyaman", "afyonkarahisar", "agri", "amasya", "ankara", "antalya", "artvin",
    "aydin", "balikesir", "bilecik", "bingol", "bitlis", "bolu", "burdur", "bursa",
    "canakkale", "cankiri", "corum", "denizli", "diyarbakir", "edirne", "elazig", "erzincan",
    "erzurum", "eskisehir", "gaziantep", "giresun", "gumushane", "hakkari", "hatay", "isparta",
    "mersin", "istanbul", "izmir", "kars", "kastamonu", "kayseri", "kirklareli", "kirsehir",
    "kocaeli", "konya", "kutahya", "malatya", "manisa", "kahramanmaras", "mardin", "mugla",
    "mus", "nevsehir", "nigde", "ordu", "rize", "sakarya", "samsun", "siirt",
    "sinop", "sivas", "tekirdag", "tokat", "trabzon", "tunceli", "sanliurfa", "usak",
    "van", "yozgat", "zonguldak", "aksaray", "bayburt", "karaman", "kirikkale", "batman",
    "sirnak", "bartin", "ardahan", "igdir", "yalova", "karabuk", "kilis", "osmaniye", "duzce"
]

def post_url(url):
    user_agents = [
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64)...",
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)...",
    ]
    headers = {
        "User-Agent": random.choice(user_agents),
        "Accept-Language": "en-US,en;q=0.9",
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9",
        "Referer": "https://www.google.com/",
        "Connection": "keep-alive"
    }
    session = requests.Session()
    response = session.get(url, headers=headers)
    soup=BeautifulSoup(response.content,"html.parser")
    return soup

def url(sehir,page):
    return f"https://www.arabam.com/ikinci-el/otomobil-{sehir}?view=List&page={page}"

sehir=post_url(url("corum","1"))
for i in sehir:
    table=sehir.find("table","table listing-table w100")
    links=table.find_all("tr","listing-list-item should-hover bg-white")
    for i in links:
        link=i.find("a","link-overlay")
        link2="https://www.arabam.com/"+link.get("href")
        son=post_url(link2)
        baslik=son.find("div","product-name-container")
        print(baslik.text.strip())
        break
    break
