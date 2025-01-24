package com.nibienvenu.kmp_cours.Components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.nibienvenu.kmp_cours.ComposeTheme.ComposeTheme


@Composable
fun Accordion() {
    LazyColumn {
        item {
            AccordionItem(
                title = "Comment créer un nouveau compte ?",
                content = "Pour créer un nouveau compte, veuillez suivre ces étapes :\n\n" +
                        "1. Ouvrez l'application.\n" +
                        "2. Appuyez sur le bouton 'S'inscrire'.\n" +
                        "3. Remplissez vos informations, y compris votre nom, adresse e-mail et mot de passe.\n" +
                        "4. Cliquez sur 'Créer un compte'.\n" +
                        "5. Vous recevrez un e-mail de confirmation pour vérifier votre compte. Suivez les instructions dans l'e-mail pour terminer le processus d'inscription."
            )
        }
        item {
            AccordionItem(
                title = "Comment réinitialiser mon mot de passe ?",
                content = "Si vous avez besoin de réinitialiser votre mot de passe, voici ce que vous devez faire :\n" +
                        "1. Sur l'écran de connexion de l'application, appuyez sur le lien 'Mot de passe oublié ?'.\n" +
                        "2. Entrez votre adresse e-mail enregistrée.\n" +
                        "3. Vous recevrez un e-mail avec un lien de réinitialisation du mot de passe.\n" +
                        "4. Cliquez sur le lien et suivez les instructions pour réinitialiser votre mot de passe.\n" +
                        "5. Une fois votre mot de passe réinitialisé, vous pourrez vous connecter avec votre nouveau mot de passe."
            )
        }
        item {
            AccordionItem(
                title = "Comment mettre à jour mes informations de profil ?",
                content = "Pour mettre à jour vos informations de profil, veuillez suivre ces étapes :\n" +
                        "1. Connectez-vous à votre compte.\n" +
                        "2. Allez dans la section 'Profil' de l'application.\n" +
                        "3. Cliquez sur le bouton 'Modifier le profil'.\n" +
                        "4. Mettez à jour les informations que vous souhaitez changer, telles que votre nom, votre photo de profil ou vos coordonnées.\n" +
                        "5. Cliquez sur 'Enregistrer' pour sauvegarder vos modifications.\n" +
                        "Vos informations de profil seront mises à jour en conséquence."
            )
        }
        item {
            AccordionItem(
                title = "Comment désactiver mon compte ?",
                content = "Si vous souhaitez désactiver votre compte, voici les étapes à suivre :\n" +
                        "1. Connectez-vous à votre compte.\n" +
                        "2. Allez dans les paramètres du compte.\n" +
                        "3. Cliquez sur 'Désactiver le compte'.\n" +
                        "4. Confirmez votre choix.\n" +
                        "Votre compte sera désactivé et vous ne pourrez plus y accéder jusqu'à ce que vous le réactiviez."
            )
        }
        item {
            AccordionItem(
                title = "Comment supprimer mon compte définitivement ?",
                content = "Si vous souhaitez supprimer votre compte de manière définitive, veuillez suivre ces étapes :\n" +
                        "1. Connectez-vous à votre compte.\n" +
                        "2. Allez dans les paramètres du compte.\n" +
                        "3. Cliquez sur 'Supprimer le compte'.\n" +
                        "4. Confirmez votre choix pour supprimer définitivement votre compte.\n" +
                        "Attention : cette action est irréversible, toutes vos données seront effacées."
            )
        }
        item {
            AccordionItem(
                title = "Comment contacter le support client ?",
                content = "Si vous avez besoin d'aide, vous pouvez contacter le support client en suivant ces étapes :\n" +
                        "1. Ouvrez l'application.\n" +
                        "2. Allez dans la section 'Support' ou 'Aide'.\n" +
                        "3. Choisissez l'option pour envoyer un message ou un e-mail.\n" +
                        "4. Décrivez votre problème ou votre question.\n" +
                        "5. Envoyez votre message et un membre de l'équipe du support client vous répondra dans les plus brefs délais."
            )
        }
        item {
            AccordionItem(
                title = "Comment gérer les notifications ?",
                content = "Pour gérer les notifications de l'application, voici ce que vous devez faire :\n" +
                        "1. Allez dans les paramètres de l'application.\n" +
                        "2. Ouvrez la section 'Notifications'.\n" +
                        "3. Choisissez les types de notifications que vous souhaitez recevoir.\n" +
                        "4. Activez ou désactivez les notifications en fonction de vos préférences."
            )
        }
        item {
            AccordionItem(
                title = "Comment activer la vérification en deux étapes ?",
                content = "Pour activer la vérification en deux étapes, suivez ces étapes :\n" +
                        "1. Connectez-vous à votre compte.\n" +
                        "2. Allez dans les paramètres de sécurité.\n" +
                        "3. Cliquez sur 'Activer la vérification en deux étapes'.\n" +
                        "4. Entrez votre numéro de téléphone pour recevoir un code de vérification.\n" +
                        "5. Saisissez le code envoyé par SMS pour finaliser l'activation."
            )
        }
        item {
            AccordionItem(
                title = "Comment changer mon adresse e-mail ?",
                content = "Pour changer votre adresse e-mail, voici les étapes à suivre :\n" +
                        "1. Connectez-vous à votre compte.\n" +
                        "2. Allez dans la section 'Profil'.\n" +
                        "3. Cliquez sur 'Modifier l'adresse e-mail'.\n" +
                        "4. Entrez la nouvelle adresse e-mail.\n" +
                        "5. Cliquez sur 'Enregistrer' pour valider la modification."
            )
        }
        item {
            AccordionItem(
                title = "Comment ajouter une carte de paiement ?",
                content = "Pour ajouter une carte de paiement, suivez ces étapes :\n" +
                        "1. Connectez-vous à votre compte.\n" +
                        "2. Allez dans la section 'Paiement'.\n" +
                        "3. Cliquez sur 'Ajouter une carte'.\n" +
                        "4. Entrez les informations de votre carte de crédit ou de débit.\n" +
                        "5. Cliquez sur 'Sauvegarder' pour enregistrer votre carte."
            )
        }
    }

}

@Composable
fun AccordionItem(title: String, content: String) {
    var expanded by remember { mutableStateOf(false) }
    val degrees by animateFloatAsState(if (expanded) -90f else 90f)

    Column {
        Row(
            modifier = Modifier
                .clip(ComposeTheme.shapes.roundL)
                .clickable { expanded = !expanded }
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BasicText(
                text = title,
                style = ComposeTheme.textStyles.base
            )
            Image(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .rotate(degrees)
                    .size(24.dp),
                colorFilter = ColorFilter.tint(ComposeTheme.colors.gray800)
            )
        }
        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                spring(
                    stiffness = Spring.StiffnessMediumLow,
                    visibilityThreshold = IntSize.VisibilityThreshold
                )
            ),
            exit = shrinkVertically()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                BasicText(
                    text = content,
                    style = ComposeTheme.textStyles.sm
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(ComposeTheme.colors.gray100)
        )
    }
}