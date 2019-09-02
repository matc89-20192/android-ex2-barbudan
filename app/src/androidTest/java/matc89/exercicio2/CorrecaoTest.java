package matc89.exercicio2;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.action.ViewActions.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CorrecaoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void checaValoresIniciaisDaPrimeiraTela() {
        onView(withId(R.id.textView))
                .check(matches(withText("Oi!")));
        onView(withId(R.id.btnTrocar))
                .check(matches(withText("Trocar usuário")));
    }

    @Test
    public void checaValoresIniciaisDaSegundaTela() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .check(matches(withText("")));

        onView(withId(R.id.btnConfirmar))
                .check(matches(withText("Confirmar")));

        onView(withId(R.id.btnCancelar))
                .check(matches(withText("Cancelar")));
    }

    @Test
    public void checaMensagemAoTrocarNome() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Sicrano"));

        onView(withId(R.id.btnConfirmar))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Oi, Sicrano!")));
    }

    @Test
    public void checaSeMensagemNaoMudaAoCancelarATrocaDeNome() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Sicrano"));

        onView(withId(R.id.btnCancelar))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Oi!")));
    }

    @Test
    public void checaSeMensagemNaoMudaAoCancelarATrocaDeNomePeloBotaoBack() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Sicrano"));

        Espresso.pressBack();

        onView(withId(R.id.textView))
                .check(matches(withText("Oi!")));
    }

    @Test
    public void checaSeCaixaDeTextoMostraUsuarioAtual() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Beltrano"));

        onView(withId(R.id.btnConfirmar))
                .perform(click());

        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .check(matches(withText("Beltrano")));
    }

    @Test
    public void checaSeStringVaziaResultaEmNaoTerUsuarioAtual() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Beltrano"));

        onView(withId(R.id.btnConfirmar))
                .perform(click());

        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(clearText());

        onView(withId(R.id.btnConfirmar))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Oi!")));
    }

    @Test
    public void checaSeMensagemSeMantemAposRotacao() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Beltrano"));

        onView(withId(R.id.btnConfirmar))
                .perform(click());

        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        onView(withId(R.id.textView))
                .check(matches(withText("Oi, Beltrano!")));
    }

    @Test
    public void checaSeUsuarioAtualSeMantemAposRotacao() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Beltrano"));

        onView(withId(R.id.btnConfirmar))
                .perform(click());

        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .check(matches(withText("Beltrano")));
    }
}
