from tkinter import *      
from tkinter import scrolledtext
import random
from tkinter import messagebox

import requests
from getpass import getpass

#{
#        "player1_id": 2,
#        "player2_id": 3
#   }

#r = requests.post("http://127.0.0.1:4567/AgregarUsuario", params = {
 #       "username": "Elpibe",
  #      "email": "ElPibe@gmail.com"
   # }) 

#url = "http://127.0.0.1:4567/AgregarUsuario"
#cabecera1 = {'Content-type': 'application/json'}
#datos = '{"username": "ElPibe", "email": "ElPibe@gmail.com" }'
#solicitud = requests.post(url, headers = cabecera1, data = datos)
#if solicitud.status_code == 200:
#    print(solicitud.text)

 
 



class App():
    def __init__(self, root):
        self.root = root
        self.nombrus = ""
        self.email = ""
        self.Przyjaciele = ["FriedrichPrussen74", "CarolusAdolphusSweedenForTheWin", "MustafaPashaKebab67"]
        self.nombrianni = "Nombre:" + self.nombrus
        self.setPreguntas = [0, 1, 2, 3, 4]
        self.pregunta = ["Co kolorowy jest czerwony?", "Carlos Martel evito que los bereberes entraran en...?", "La cacion One Way Or Another pertenece a...?", "Cuantos protones tiene el litio?", "Que libreria conecta sencillamente Python y MongoDb sin utilizar una API?"]
        self.setRespuestas = ["To nie", "To tez nie", "To mniej", "To tak"], ["Francia", "Alemania", "Brazil", "Marruecos"], ["Blondie", "Depeche Mode", "Ensiferum", "Bjork"], ["10", "21", "13", "3"], ["PyMongo", "MongoPy", "PyMo", "MongoConnect"]
        self.terminado = "0"
        self.correcta = [4, 1, 1, 4, 1]      
        self.login()



    def login(self):    
        self.pantallaLogin = Frame()
        self.canvas = Canvas(self.pantallaLogin, width = 220, height = 210)   
        self.img = PhotoImage(file="PalabraRota.png")      
        self.canvas.create_image(30,30, anchor=NW, image=self.img)
        self.text3 = Text(self.pantallaLogin, width = 35, height = 1)
        self.text4 = Text(self.pantallaLogin, width = 35, height = 1)
        self.labelu4 = Label(self.pantallaLogin, text="Nombre:")
        self.text4.insert(INSERT, "")
        self.labelu5 = Label(self.pantallaLogin, text="Email:")
        self.text3.insert(INSERT, "")
        self.butony = Button(self.pantallaLogin, text="Ingresar", width = 20, command=self.VerificarCuenta)
        self.butony4 = Button(self.pantallaLogin, text="Salir", width = 20, command=self.SalirDeLaApp)
        self.canvas.pack()  
        self.labelu4.pack()    
        self.text3.pack()
        self.labelu5.pack()
        self.text4.pack()
        self.butony.pack()
        self.butony4.pack()
        self.pantallaLogin.pack()
        self.labeluR = Label(self.pantallaLogin, text="Usuario no encontrado, por favor reintentelo o cree una cuenta")


    def menu(self):
        self.Przyjaciele = (requests.post("http://127.0.0.1:4567/buscarIdPorDocument", headers = {'Content-type': 'application/json'}, data = (self.nombrus))).text
        print(self.Przyjaciele)
        self.pantallaPrincipal = Frame()
        self.labeluN2 = Label(self.pantallaPrincipal, text= self.nombreLogueado)
        self.labelu = Label(self.pantallaPrincipal, text="Informacion de Usuario:")
        self.labelu.grid(column=1, row=1, sticky = S)
        self.labeluN2.grid(column=1, row=2)
        self.menuJuego = Menu(self.pantallaPrincipal)
        self.jugarAmigos = Menu(self.menuJuego)
        self.sumarAmigos = Menu(self.menuJuego)
        IDSAmigos = "0"
        IDSint = []
        for IDAmigo in self.Przyjaciele:
            print(IDAmigo)
            if str(IDAmigo).isdigit():
                IDSAmigos = IDSAmigos + str(IDAmigo)
                print(IDSAmigos)
                pass
            else:
                IDSint.append(int(IDSAmigos))
                print(IDSint)
                IDSAmigos = ""
                pass

            pass
        IDSint.remove(0)
        self.Przyjaciele = IDSint
        self.jugarAmigos.add_command(label = "Jugar con Amigos", command = (lambda: (self.pantallaDeJugarAmigos())))
        self.menuJuego.add_cascade(label = "Jugar con", menu = self.jugarAmigos)
        self.sumarAmigos.add_command(label = "Agregar Amigo", command = self.agregarAmigo)
        self.menuJuego.add_cascade(label = "Agregar Amigos", menu = self.sumarAmigos)
        self.root.config(menu = self.menuJuego)
        self.butony3 = Button(self.pantallaPrincipal, text="Salir", width = 20, command=self.SalirDeLaApp)
        self.butony3.grid(column=0, row=1)
        self.butony4 = Button(self.pantallaPrincipal, text="Ver Partidas Activas", width = 20, command=self.irAPartidasSinTemrinar)
        self.butony4.grid(column=0, row=2)


    def partida(self):
        if self.terminado == "0":
            self.numeroR = random.choice(self.setPreguntas)
            self.pantallaDeJuego = Frame()
            self.labelu = Label(self.pantallaDeJuego, text = self.pregunta[self.numeroR])
            self.labelu.grid(column=2, row=0)
            self.butony1 = Button(self.pantallaDeJuego, text= self.setRespuestas[self.numeroR][0], width = 20, height = 2, bg = "blue", command= (lambda: (self.resolverRespuesta(1))))
            self.butony2 = Button(self.pantallaDeJuego, text= self.setRespuestas[self.numeroR][1], width = 20, height = 2, bg = "green", command= (lambda: (self.resolverRespuesta(2))))
            self.butony3 = Button(self.pantallaDeJuego, text= self.setRespuestas[self.numeroR][2], width = 20, height = 2, bg = "yellow", command= (lambda: (self.resolverRespuesta(3))))
            self.butony4 = Button(self.pantallaDeJuego, text= self.setRespuestas[self.numeroR][3], width = 20, height = 2, bg = "red", command= (lambda: (self.resolverRespuesta(4))))
            self.butony1.grid(column=1, row=1)
            self.butony2.grid(column=1, row=2)
            self.butony3.grid(column=3, row=1)
            self.butony4.grid(column=3, row=2)
        else:
            self.resultadoP()
            self.pantallaDeResultado.pack()
            pass

        
    def partidasSinTerminar(self):
        self.pantallaPartidas = Frame(height = 200, width = 100)
        self.labeluS = Label(self.pantallaPartidas, text = "Partidas sin terminar")
        self.labeluS.pack()
        scrollbar = Scrollbar(self.pantallaPartidas)
        scrollbar.pack( side = RIGHT, fill = Y )
        idpartidas = (requests.post("http://127.0.0.1:4567/partidasDeUnUsuarioSinTerminar", headers = {'Content-type': 'application/json'}, data = str(self.idLogueado))).text
        IDSPartidas = "0"
        IDSint = []
        for IDPartida in idpartidas:
            print(IDPartida)
            if str(IDPartida).isdigit():
                IDSPartidas = IDSPartidas + str(IDPartida)
                print(IDSPartidas)
                pass
            else:
                IDSint.append(int(IDSPartidas))
                print(IDSint)
                IDSPartidas = ""
                pass
            pass
        IDSint.remove(0)
        idpartidas = IDSint



        mylist = Listbox(self.pantallaPartidas, yscrollcommand = scrollbar.set )




        for idpartida in idpartidas:
            idParticipantes = (requests.post("http://127.0.0.1:4567/obtenerIdsUsuariosGame", headers = {'Content-type': 'application/json'}, data = str(idpartida))).text
                
                
            IDSJugadores = "0"
            IDSint2 = []
            for IDJugador in idParticipantes:
                print(IDJugador)
                if str(IDJugador).isdigit():
                    IDSJugadores = IDSJugadores + str(IDJugador)
                    print(IDSJugadores)
                    pass
                else:
                    IDSint2.append(int(IDSJugadores))
                    print(IDSint2)
                    IDSJugadores = ""
                    pass

                pass
            IDSint2.remove(0)
            idParticipantes = IDSint2
                
                
            print(str(idParticipantes) + "id")
            print(str(idParticipantes[0]) + "id")
            print(str(idParticipantes[1]) + "id")
            nombreContrincante1 = (requests.post("http://127.0.0.1:4567/buscarNombrePorId", headers = {'Content-type': 'application/json'}, data = str(idParticipantes[0]))).text
            print(nombreContrincante1 + "con1")
            nombreContrincante2 = (requests.post("http://127.0.0.1:4567/buscarNombrePorId", headers = {'Content-type': 'application/json'}, data = str(idParticipantes[1]))).text
            print(nombreContrincante2 + "con2")
            mylist.insert(END, (nombreContrincante1 +  " vs " + nombreContrincante2 + " Id de la Partida: " + str(idpartida)))
            
            pass
        mylist.pack( fill = BOTH )
        scrollbar.config( command = mylist.yview )
        self.labeluAm = Label(self.pantallaPartidas, text = "Ingrese la id de la partida a la que quiere ingresar")
        self.labeluAm.pack()
        self.entradaPar = Entry(self.pantallaPartidas, bd =5)
        self.entradaPar.pack()
        self.butonyPar = Button(self.pantallaPartidas, text= "Unirse a partida", width = 20, height = 1, command= (lambda idpartida=idpartida: (self.unirseAPartida(self.entradaPar.get()))))
        self.butonyPar.pack()
        self.butonyAm2 = Button(self.pantallaPartidas, text= "Volver", width = 10,  command=self.volver2)
        self.butonyAm2.pack()



    def jugarConAmigos(self):
        self.pantallaJugarAmigos = Frame(height = 200, width = 100)
        self.labeluJ = Label(self.pantallaJugarAmigos, text = "Amigos")
        self.labeluJ.pack()
        scrollbar2 = Scrollbar(self.pantallaJugarAmigos)
        scrollbar2.pack( side = RIGHT, fill = Y )
        mylist2 = Listbox(self.pantallaJugarAmigos, yscrollcommand = scrollbar2.set )
        for amigo in self.Przyjaciele:
            idAmigoJ = (requests.post("http://127.0.0.1:4567/buscarNombrePorId", headers = {'Content-type': 'application/json'}, data = str(amigo))).text
            print(type(idAmigoJ))
            print(type(amigo))
            mylist2.insert(END, (idAmigoJ + " Id: " + str(amigo)))
            pass
        mylist2.pack( fill = BOTH )
        scrollbar2.config( command = mylist2.yview )
        self.labeluJ4 = Label(self.pantallaJugarAmigos, text = "Ingrese la id del amigo con el que quiere jugar")
        self.labeluJ4.pack()
        self.entradaJ = Entry(self.pantallaJugarAmigos, bd =5)
        self.entradaJ.pack()
        self.butonyJ3 = Button(self.pantallaJugarAmigos, text= "Jugar con", width = 20, height = 1, command= (lambda idpartida=idAmigoJ: (self.BuscarPartida(self.entradaJ.get() ) ) ) )
        self.butonyJ3.pack()
        self.butonyJ2 = Button(self.pantallaJugarAmigos, text= "Volver", width = 10,  command=self.volver3)
        self.butonyJ2.pack()



    def unirseAPartida(self, idDeLaPartida):
        self.idPartidaActual = idDeLaPartida
        self.terminado = (requests.post("http://127.0.0.1:4567/cerrarPartida", headers = {'Content-type': 'application/json'}, data = str(self.idPartidaActual))).text
        self.pantallaPartidas.destroy()
        self.partida()
        self.pantallaDeJuego.pack()

    def resultadoP(self):
        self.pantallaDeResultado = Frame()
        self.butonia = Button(self.pantallaDeResultado, text= "Volver a jugar", width = 20, bg = "green", command=self.VolverAJugar)
        self.butonia2 = Button(self.pantallaDeResultado, text= "Volver al menu", width = 20, bg = "red", command=self.VolverAlMenu)
        self.idGanador = (requests.post("http://127.0.0.1:4567/verGanador", headers = {'Content-type': 'application/json'}, data = str(self.idPartidaActual)).text)
        self.nombreGanador = (requests.post("http://127.0.0.1:4567/buscarNombrePorId", headers = {'Content-type': 'application/json'}, data = self.idGanador)).text
        self.labelu = Label(self.pantallaDeResultado, text = "Ganador: " + self.nombreGanador )
        self.labelu.grid(column=1, row=1)
        self.butonia.grid(column = 0, row = 2)
        self.butonia2.grid(column = 2, row = 2)
    
    def SalirDeLaApp(self):
        self.root.destroy()
        
    def VerificarCuenta(self):
        self.labeluR.destroy()
        url = "http://127.0.0.1:4567/comprobarExistenciaDeUnUsuario"
        self.nombrus = self.text3.get("1.0", "end-1c")
        self.email = self.text4.get("1.0", "end-1c")
        cabecera1 = {'Content-type': 'application/json'}
        datos = '{"username": %s, "email": %s }' % (self.nombrus, self.email)
        solicitud = requests.post(url, headers = cabecera1, data = datos)
        if solicitud.status_code == 200:
            print(solicitud.text)
            if solicitud.text == "true":
                self.idLogueado = requests.post("http://127.0.0.1:4567/buscarIdPorNombre", headers = {'Content-type': 'application/json'}, data = (self.nombrus))
                self.idLogueado = int(self.idLogueado.text)
                print(self.idLogueado)
                print(self.Przyjaciele)
                self.nombreLogueado = self.nombrus
                self.pantallaLogin.destroy()
                self.menu()
                self.pantallaPrincipal.pack()
                pass
            else:
                self.labeluR = Label(self.pantallaLogin, text="Usuario no encontrado, por favor reintentelo o cree una cuenta")
                self.labeluR.pack()
                
                pass
        
    def agregarAmigo(self):
        self.pantallaPrincipal.destroy()
        self.seccionAgregar()
        self.pantallaAgregarAmigo.pack()

    def pantallaDeJugarAmigos(self):
        self.pantallaPrincipal.destroy()
        self.jugarConAmigos()
        self.pantallaJugarAmigos.pack()


    def seccionAgregar(self):
        self.pantallaAgregarAmigo = Frame()
        self.labeluAm = Label(self.pantallaAgregarAmigo, text = "Ingrese el nombre del amigo que desea agregar")
        self.labeluAm.pack()
        self.entradaAm = Entry(self.pantallaAgregarAmigo, bd =5)
        self.entradaAm.pack()
        self.butonyAm = Button(self.pantallaAgregarAmigo, text= "Agregar", width = 10,  command=self.agregarAmigo2)
        self.butonyAm.pack()
        self.butonyAm2 = Button(self.pantallaAgregarAmigo, text= "Volver", width = 10,  command=self.volver)
        self.butonyAm2.pack()
        pass
        
    def agregarAmigo2(self):
        try:
            print(self.entradaAm.get())
            amigoAAgregar = (requests.post("http://127.0.0.1:4567/buscarIdPorNombre", headers = {'Content-type': 'application/json'}, data = (self.entradaAm.get()))).text
            print(amigoAAgregar)
            IDs = [amigoAAgregar, str(self.idLogueado)]
            print(IDs)
            result = (requests.post("http://127.0.0.1:4567/agregarAmigo", headers = {'Content-type': 'application/json'}, data = str(IDs) )).text
            print(result)
            pass
        except:
            messagebox.showerror("Error", "Error Fatal")
            pass
        
    def volver(self):
            self.pantallaAgregarAmigo.destroy()
            self.menu()
            self.pantallaPrincipal.pack()
            pass

    def volver2(self):
        self.pantallaPartidas.destroy()
        self.menu()
        self.pantallaPrincipal.pack()
        pass

    def volver3(self):
        self.pantallaJugarAmigos.destroy()
        self.menu()
        self.pantallaPrincipal.pack()
        pass
        
        
    def BuscarPartida(self, idJugador2):
        self.jugador2 = idJugador2
        self.pantallaJugarAmigos.destroy()
        self.idPartidaActualSTR = (requests.post("http://127.0.0.1:4567/agregarGame", headers = {'Content-type': 'application/json'}, data = '{"player1_id": %s, "player2_id": %s }' % (self.idLogueado, idJugador2))).text
        self.idPartidaActual = int(self.idPartidaActualSTR) - 1
        self.partida()
        self.pantallaDeJuego.pack()




    def resolverRespuesta(self, seleccion):
        print(self.idPartidaActual)
        print(type(self.terminado))
        arrayPartida = [str(self.idPartidaActual), str(self.idLogueado)]
        
        if seleccion == self.correcta[self.numeroR]:
            self.terminado = (requests.post("http://127.0.0.1:4567/cerrarPartida", headers = {'Content-type': 'application/json'}, data = str(self.idPartidaActual))).text
            self.pantallaDeJuego.destroy()
            self.partida()
            if self.terminado == "0":
                requests.post("http://127.0.0.1:4567/SumarPuntos", headers = {'Content-type': 'application/json'}, data = str(arrayPartida))
                pass
            if self.terminado == "0":
                self.pantallaDeJuego.pack()
                pass
            pass
        else:
            requests.post("http://127.0.0.1:4567/quitarPuntos", headers = {'Content-type': 'application/json'}, data = str(arrayPartida))
            self.pantallaDeJuego.destroy()
            self.partida()
            if self.terminado == "0":
                self.pantallaDeJuego.pack()
                pass
            pass
            
        pass




    def VolverAJugar(self):
        self.pantallaDeResultado.destroy()
        self.idPartidaActualSTR = (requests.post("http://127.0.0.1:4567/agregarGame", headers = {'Content-type': 'application/json'}, data = '{"player1_id": %s, "player2_id": %s }' % (self.idLogueado, self.jugador2))).text
        self.idPartidaActual = int(self.idPartidaActualSTR) - 1
        self.partida()
        self.pantallaDeJuego.pack()

        pass

    def VolverAlMenu(self):
        self.pantallaDeResultado.destroy()
        self.menu()
        self.pantallaPrincipal.pack()
        pass

    def irAPartidasSinTemrinar(self):
        self.pantallaPrincipal.destroy()
        messagebox.showinfo("Puede tardar", "Pongase comodo! esto puede tomar unos segundos, apriete OK para comenzar")
        self.partidasSinTerminar()
        self.pantallaPartidas.pack()
        pass



















root = Tk()
app = App(root)


mainloop() 